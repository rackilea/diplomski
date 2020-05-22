public abstract class Document<T extends Paper> {
    private final ArrayList<T> paperList;


    protected Document(ArrayList<T> paperList) {
        this.paperList = paperList;
    }
}