public class Data {
    String title;
    String classs;
    String section;
    double price;

    public Data(String title, double price) {
        this.title = title;
        this.price = price;
    }

    public Data(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getClasss() {
        return classs;
    }

    public void setClasss(String classs) {
        this.classs = classs;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }
}