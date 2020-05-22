public class BookRecyclerAdopter extends RecyclerView.Adapter<BookRecyclerAdopter.Booksholder>{

    private List<String> bookname;
    private List<String> filteredBookname;

Context context;

    public BookRecyclerAdopter(Context context,List<String> bookname) {
        this.bookname = bookname;
        this.filteredBookname = bookname
        this.context=context;

    }
...
// other pieces of code.