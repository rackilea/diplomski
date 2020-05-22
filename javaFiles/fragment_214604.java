@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container,
        Bundle savedInstanceState) {
    View rootView = inflater.inflate(R.layout.fragment_main, container,
            false);
      counter=0;
      add=(Button) rootView.findViewById(R.id.Add);
      sub=(Button) rootView.findViewById(R.id.Sub);
      disp=(TextView) rootView.findViewById(R.id.Display);
      add.setOnClickListener(new View.OnClickListener() {

      @Override
      public void onClick(View v) {
        // TODO Auto-generated method stub
        counter++;
        disp.setText("counter is "+counter);

     }
     });

    sub.setOnClickListener(new View.OnClickListener() {

    @Override
    public void onClick(View v) {
        // TODO Auto-generated method stub

        counter++; 
        disp.setText("counter is "+counter);

    }
   });

    return rootView;
}