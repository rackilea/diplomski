class wallet {
    private String Name;
    private String Location;
    private String Tag;
    private String Reader;


    public wallet(String Name, String Location, String Tag, String Reader) {
        this.Name = Name;
        this.Location = Location;
        this.Tag = Tag;
        this.Reader = Reader;

    }


    public wallet(String Reader) {
        this.Reader = Reader;
        this.Name = "unknown";
        this.Location = "unknown";
        this.Tag = "unknown";
    }

    public wallet(String Location, String Tag) {
        this.Location = Location;
        this.Tag = Tag;
    }

    public String getWalletName() {
        return Name;
    }

    public void setWalletName(String Name) {
        this.Name = Name;
    }

    public String getWalletLocation() {
        return Location;
    }

    public void setWalletLocation(String Location) {
        this.Location = Location;
    }

    public String getWalletTag() {
        return Tag;
    }

    public void setWalletTag(String Tag) {
        this.Tag = Tag;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        if (isPrintableValue(this.Name)) {
            sb.append(this.Name + ",");
        }
        if (isPrintableValue(this.Location)) {
            sb.append(this.Location + ",");
        }
        if (isPrintableValue(this.Tag)) {
            sb.append(this.Tag + ",");
        }
        if (isPrintableValue(this.Reader)) {
            sb.append(this.Reader);
        }

        return sb.toString();
    }

    protected boolean isPrintableValue(String value) {
        return (value != null && !value.equals("unknown"));
    }
}

public class Test {

    public static void main(String[] args) {
        wallet wallet = new wallet("Omar");
        System.out.println(wallet);
    }
}