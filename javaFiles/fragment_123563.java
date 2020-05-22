public class MyAdapter {

   MyAdapterListener listener;

   private MyAdapter() {}

   public MyAdapter(MyAdapterListener listeningActivityOrFragment) {

      listener = listeningActivityOrFragment;

   }
}



public interface MyAdapterListener {

   void somethingTheFragmentNeedsToKnow(Object someData);

}


public class SomeFragment extends Fragment implements  MyAdapterListener {

   @Override
   public View onCreateView(LayoutInflater inflater, ViewGroup container,
                            Bundle savedInstanceState) {
      // Inflate the layout for this fragment
      View view = inflater.inflate(R.layout.my_view, container, false);

      // Do everyhting here to init your view.

      // Create an Adapter and bind it to this fragment
      MyAdapter myAdapter = new MyAdapter(this);

      return view;

   }

// Implement the listener interface

   @Override
   public void somethingTheFragmentNeedsToKnow(Object someData) {

      // Get the data and process it.

   }
}