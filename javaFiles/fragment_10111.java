@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
counter = 0;
add = (Button) rootView.findViewById (R.id.bAdd);
sub = (Button) rootView.findViewById (R.id.bsub);
display = (TextView) rootView.findViewById(R.id.tvDisplay);
add.setOnClickListener(new  View.OnClickListener() {

 @Override
 public void onClick(View v) {
 // TODO Auto-generated method stub
  counter++;
   display.setText("Your total is " + counter);

    }
   });

  sub.setOnClickListener(new  View.OnClickListener() {

   @Override
   public void onClick(View v) {
   // TODO Auto-generated method stub
   counter --;
   display.setText("Your total is " + counter);
   }
  });
 return rootView;
}