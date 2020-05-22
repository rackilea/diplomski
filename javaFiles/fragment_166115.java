public class MyFragment extends Fragment {

    MyInterface interface1;
    Button btnChange;

     @Override
     public View onCreateView(LayoutInflater inflater, ViewGroup container,
       Bundle savedInstanceState) {
      // TODO Auto-generated method stub
      View myFragmentView = inflater.inflate(R.layout.fragmentlayout, container, false);
      btnChange=(Button)findViewById(R.id.displayfragment1);
      btnChange.setOnClickListener(new OnClickListener() {
        @Override
        public void onClick(View v) {
            interface1.buttonClicked(v);
        }
    });
      return myFragmentView;
     }



  public void setInterface(MyInterface interface2) {
    this.interface1 = interface2;
   }


}