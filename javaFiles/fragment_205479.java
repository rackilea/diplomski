public class PageFragment extends Fragment {

    public static PageFragment newInstance(int pageNumber, Context ctx){

            Bundle args = new Bundle();
            args.putInt(EXTRA_PAGENUMBER, pageNumber);
            PageFragment fragment = new PageFragment();
            fragment.setArguments(args);

            final Context context = ctx;

            new Thread(new Runnable() {

                @Override
                public void run() {
                // use ctx here
            }).start();

            return fragment;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
}