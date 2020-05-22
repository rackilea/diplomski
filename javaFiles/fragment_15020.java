public class ControladorImpressao {

    @Value("${nome.impressora}")
    private String nomeImpressora;
    private PDDocument arquivoPDF;
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public boolean imprimir(String arquivo) {
        try {
            arquivoPDF=PDDocument.load(new File(arquivo));
            PrinterJob job = PrinterJob.getPrinterJob();
            job.setPrintService(recuperarImpressora());
            job.setJobName(arquivo);
            job.setPageable(arquivoPDF);
            job.print();
            return true;
        } catch (Exception e) {
            logger.error("Erro ao tentar imprimir documento!",e);
        }
        return false;
    }

    private PrintService recuperarImpressora() {
        PrintService[] printServices = PrinterJob.lookupPrintServices();
        for (int count = 0; count < printServices.length; ++count) {
            if (nomeImpressora.equalsIgnoreCase(printServices[count].getName())) {
                return printServices[count];
            }
        }
        return null;
    }
}