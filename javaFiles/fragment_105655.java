public class Foo {
    private ReadingList mReadingList = new ReadingList();

    public void setReadingListName(String name) {
        synchronized(mReadingList) {
           mReadingList.setName(name);
        }
    }

    public void setReadingListAuthor(String author) {
        synchronized(mReadingList) {
           mReadingList.setAuthor(author);
        }
    }

    ...