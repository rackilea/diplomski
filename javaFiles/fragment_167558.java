public class AddBookToSession extends ActionSupport implements SessionAware {

    private Integer bid;
    private Map<String, Object> session;

    private BookdetailsDAO dao = new BookdetailsDAO(); 

    public String execute() { 
        BookDetails book = dao.listBookDetailsById(Integer.parseInt(bookid));
        if (book != null) {
            List<Bookdetails> books = sessionBooks();
            books.add(book);
        }

        return SUCCESS;
    } 

    private List<Bookdetails> sessionBooks() {
        List<Bookdetails> books = (List) session.get(BillTransactionBooksConstants.BOK);
        if (books == null) {
            books = new ArrayList<BookDetails>();
            session.put(BillTransactionBooksConstants.BOK, books);
        }
        return books;
    }

    public void setSession(Map<String, Object> session) {
        this.session = session;
    }

    public Integer getBid() {
        return this.bid;
    }

    public void setBid(Integer bid) {
        this.bid = bid;
    }
}