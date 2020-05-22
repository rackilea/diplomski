public class ConBeitragTest {

    public static void main(String[] args) {
        ConBeitrag con = new ConBeitrag(1, 2, 3, "test", "test", "test");
        System.out.println(con);
    }
}

class ConBeitrag {

    private int beitragid;
    private int projektid;
    private int mitarbeiterid;
    private String beitragText;
    private String erstellt_am;
    private String geaendert_am;
    private String schlagwort1;
    private String schlagwort2;

    public ConBeitrag() {

    }

    public ConBeitrag(int beitragid, int projektid, int mitarbeiterid, String beitragText, String erstellt_am, String geaendert_am) {

        this.beitragid = beitragid;
        this.projektid = projektid;
        this.mitarbeiterid = mitarbeiterid;
        this.erstellt_am = erstellt_am;
        this.geaendert_am = geaendert_am;
        this.beitragText = beitragText;
        this.schlagwort1 = schlagwort1;         // This is null
        this.schlagwort2 = schlagwort2;         // This is null
    }

    @Override
    public String toString() {
        return mitarbeiterid + beitragText + erstellt_am + schlagwort1 + schlagwort2;
    }

}