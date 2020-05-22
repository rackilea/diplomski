public class BookListingActivityFragment extends Fragment 
        implements AsyncResponse {

    private GoogleBookAsyncTask mGoogleBookAsyncTask;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
            // .......

            // Pass "delegate" interface as 'this'
            mGoogleBookAsyncTask = new GoogleBookAsyncTask(this);
            mmGoogleBookAsyncTask.execute();
        }

    // This is the interface implementation that is called from the AsyncTask
    @Override
    public void processFinish(ArrayList<Book> bookArrayList) {
        mBookArrayAdapter.clear();
        mBookArrayAdapter = new BookAdapter(getContext(), bookArrayList);
        mBookArrayAdapter.notifyDataSetChanged();
    }

}