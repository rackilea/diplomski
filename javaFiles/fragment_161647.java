int currentindex;
public void onCreate(Bundle savedInstanceState)
{
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_detail);

    Bundle bundle = getIntent().getExtras();
    // add cast to ArrayList<Actors>
    final ArrayList<Actors> arrayList= (ArrayList<Actors>)  bundle.getSerializable("information");
      currentindex = bundle.getInt("index");
    textName = (TextView) findViewById(R.id.textName);
    textName.setText(""+arrayList.arrayList.get(currentindex).getName());
    btnNext = (Button) findViewById(R.id.button1);
    btnPrev = (Button) findViewById(R.id.button2);

    btnNext.setOnClickListener(new OnClickListener() {

        @Override
        public void onClick(View arg0) {
            // TODO Auto-generated method stub
            currentindex=currentindex+1;
            if(currentindex<arrayList.size()){
                 textName.setText(""+arrayList.get(currentindex).getName());
            }
            else{
                currentindex=currentindex-1;
            }


        }
    });

    btnPrev.setOnClickListener(new OnClickListener() {

        @Override
        public void onClick(View arg0) {
            // TODO Auto-generated method stub
            currentindex=currentindex-1;
            if(currentindex>=0){
                 textName.setText(""+arrayList.get(currentindex).getName());
            }
            else{
                currentindex=currentindex+1;
            }
        }
    });