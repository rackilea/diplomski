public class Row {
    private int bandiera;
    private int positivo;
    private int negativo;
    private String piatti;
    private String qta;
    private String ntavolo;

    public Row(int bandiera, int positivo, int negativo, String piatta, String qta, String ntavolo) {
        this.bandiera = bandiera;
        this.positivo = positivo;
        this.negativo = negativo;
        this.piatti = piatta;
        this.qta = qta;
        this.ntavolo = ntavolo;
    }
}