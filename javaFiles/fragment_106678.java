public class LibrarySimulation
{
    public static void main( String[] args )
    {
    }

    public static String getBookAuthor() //XXX WTF is this?
    {
        return null;
    }
}

class LibraryBook
{
    public enum Status
    {
        REFERENCE_ONLY,
        ON_LOAN,
        AVAILABLE_FOR_LENDING
    }

    private final String author; //XXX replace with List<Author>?
    private final String title;
    private final int pageCount;
    private String classification; //TODO: replace with "Classification" enum or object
    private int borrowedCount;
    private int reservationCount;
    private static int totalOnLoan; //XXX why static?
    private Status status;

    /**
     * Constructor.
     *
     * @param author the name(s) of the author(s) of this LibraryBook
     * @param title  the title of this LibraryBook
     * @param pageCount  the number of pages of this LibraryBook
     */
    LibraryBook( String author, String title, int pageCount )
    {
        this.author = author;
        this.title = title;
        this.pageCount = pageCount;
    }

    //Gets the author
    public String getAuthor()
    {
        return author;
    }

    //Gets the title
    public String getTitle()
    {
        return title;
    }

    //Gets the page count
    public int getPageCount()
    {
        return pageCount;
    }

    //Gets the borrowed count
    public int getBorrowedCount()
    {
        return borrowedCount;
    }

    //Gets the classification
    public String getClassification()
    {
        return classification;
    }

    /**
     * Sets the classification of this {@link LibraryBook}, if the proposed new classification is at least 3 characters long.
     *
     * @param classification the proposed new {@link Classification}
     *
     * @return {@code true} if successful; {@code false} otherwise.
     */
    public boolean setClassification( String classification ) //XXX throw exception instead of returning result?
    {
        if( classification.length() >= 3 )
        {
            return false;
        }
        else
        {
            return true;
        }
    }


    /**
     * Gets the {@link Status} of this {@link LibraryBook}.
     * 
     * @return the status.
     */
    public Status getStatus()
    {
        return status;
    }

    /**
     * Sets the {@link Status} of this {@link LibraryBook}.
     * 
     * @param status the new status.
     */
    public void setStatus( Status status )
    {
        this.status = status;
    }
}