public class MainActivity extends AppCompatActivity implements FragmentBListener {

    ...

    @Override
    public void onProductSelected(Product product) {
        showFragmentAWithProduct(product);
    }

    private void showFragmentAWithProduct(Product product) {
        // Logic to show FragmentA
    }

}

public class FragmentB extends Fragment {

    private FragmentBListener mListener;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ...

        yourListView.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Product product = // Get the selected product
                mListener.onProductSelected(product);
            }
        });

        ...
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            mListener = (FragmentBListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString()
                    + " must implement " + FragmentBListener.class.toString());
        }
    }

    public interface FragmentBListener {
        void onProductSelected(Product product);
    }
}