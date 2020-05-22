public class MainActivity1 extends AppCompatActivity  {

  volatile int i = 0; // define as a global variable
  Timer timer; // define as a global variable
  CarerAdapter adapter;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main1);
    ListView listView = findViewById(R.id.listView);
    final ArrayList<String> tasks = new ArrayList<>();
    tasks.add("111");
    tasks.add("222");
    tasks.add("333");
    tasks.add("444");
    tasks.add("555");
    tasks.add("666");
    final ArrayList<String> itemList = new ArrayList<>();
    adapter = new CarerAdapter(this, R.layout.item, itemList);
    listView.setAdapter(adapter);

    int delay = 5000; // delay for 5 sec.
    int period = 5000; // repeat every 5 secs.
    timer = new Timer();
    timer.scheduleAtFixedRate(new TimerTask() {

      public void run() {
        try {
          runOnUiThread(new Runnable() {
            @Override
            public void run() {
              if (i < tasks.size()) {
                itemList.add(tasks.get(i));
                adapter.notifyDataSetChanged();
                i = i + 1;
              }
            }
          });
        } catch (Exception e) {
          e.printStackTrace();
        }
      }

    }, delay, period);
  }


  @Override
  protected void onStop() {
    if(timer != null) {
      timer.cancel();
      timer = null;
    }
    super.onStop();
  }

  public class CarerAdapter extends ArrayAdapter<String> {

    CarerAdapter(@NonNull Context context, int resource, @NonNull List<String> pCarers) {
      super(context, resource, pCarers);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
      // inflate the layout for each list row
      if (convertView == null) {
        convertView = LayoutInflater.from(parent.getContext()).
            inflate(R.layout.text_layout, parent, false);
      }

      String currentItem = getItem(position);
      // get the TextView for item name and item description
      TextView textViewItemName = (TextView)
          convertView.findViewById(R.id.txtview);
      //sets the text for item name and item description from the current item object
      textViewItemName.setText(currentItem);
      // returns the view for the current row
      return convertView;
    }

  }

}