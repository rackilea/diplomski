public class MyFragment extends Fragment {

   public interface FragmentInterface {
       void fragmentInterfaceMethod(int your_value);
   }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_word_definition, container, false);

        int myValue = 123;
        ((FragmentInterface)getActivity()).fragmentInterfaceMethod(myValue);

        return mView;
    }
}