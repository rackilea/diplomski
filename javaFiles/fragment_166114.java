public class MyFragment extends Fragment {

    MyInterface interface1;
    Button btnChange;

     @Override
     public View onCreateView(LayoutInflater inflater, ViewGroup container,
       Bundle savedInstanceState) {
      // TODO Auto-generated method stub
      View myFragmentView = inflater.inflate(R.layout.fragmentlayout, container, false);
      btnChange=(Button)findViewById(R.id.displayfragment1);
      return myFragmentView;
     }


     public void setOnClickListener(OnClickListener listener){    
         btnChange.setOnClickListener(listener);
     }



}