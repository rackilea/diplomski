public class SourceFilter extends PFGeneralFilter {
private String appPath;
public SourceFilter(String appPath) {
    super();
    this.appPath = appPath;
}

@Override
public void compute() throws EndOfStreamException {
    try {
        BufferedReader brForBankingData = new BufferedReader(new FileReader(new File(appPath + Constant.BANKING_DATA_FILE)));
        String bankingDatum = "";
        while((bankingDatum = brForBankingData.readLine()) != null) {
            this.outPorts[Constant.DEFAULT_PORT].write(Utility.convertStringToByteArray(bankingDatum));
        }
        brForBankingData.close();
        throw new EndOfStreamException();
    } catch (IOException e) {
        throw new EndOfStreamException();
    }
}
}