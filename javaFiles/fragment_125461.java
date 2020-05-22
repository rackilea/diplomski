public class Section8 {
    public static void main(String[] args) {
        Reader reader = new Reader();
        for (ASections asection : ASections.values()) {
            System.out.println(reader.getSectionText(asection));
        }
        for (BSections bsection : BSections.values()) {
            System.out.println(reader.getSectionText(bsection));
        }
    }
}