public class FragmentOne extends Fragment {
   @Override
   public View onCreateView(LayoutInflater inflater,
      ViewGroup container, Bundle savedInstanceState) {

       //Inflate the layout for this fragment

      return inflater.inflate(
              R.layout.fragment_one, container, false);


      }
    }