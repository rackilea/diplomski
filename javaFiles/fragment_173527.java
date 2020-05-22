public class MainActivity extends Activity {

    private ListView lstFood;
    ArrayList<HashMap<String,String>> foodList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lstFood = (ListView) findViewById(R.id.lstFood);

        foodList = new ArrayList<HashMap<String, String>>();
        HashMap<String,String> food1 = new HashMap<String,String>();
        food1.put("id","1");
        food1.put("name","pasta");
        food1.put("prize","99");
        food1.put("time",String.valueOf(Calendar.getInstance().getTime()));

        HashMap<String,String> food2 = new HashMap<String,String>();
        food2.put("id","2");
        food2.put("name","pizza");
        food2.put("prize","199");
        food2.put("time",String.valueOf(Calendar.getInstance().getTime()));

        foodList.add(food1);
        foodList.add(food2);

        CustomAdapter adapters = new CustomAdapter(this,foodList);
        lstFood.setAdapter(adapters);
        lstFood.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                HashMap<String,String> food = foodList.get(position);
                System.out.println("Food Id : "+food.get("id"));
                System.out.println("Food Name : "+food.get("name"));
                System.out.println("Food Prize : "+food.get("prize"));
                System.out.println("Food Time : "+food.get("time"));
            }
        });

    }

    class CustomAdapter extends BaseAdapter {

        private Context mContext;
        private ArrayList<HashMap<String,String>> foodList;

        public CustomAdapter(Context mContext,ArrayList<HashMap<String,String>> foodList) {
            this.mContext = mContext;
            this.foodList = foodList;
        }

        @Override
        public Object getItem(int position) {
            return foodList.get(position);
        }

        @Override
        public int getCount() {
            return foodList.size();
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder holder;
            if (convertView == null) {
                holder = new ViewHolder();
                convertView = LayoutInflater.from(mContext).inflate(R.layout.list_item, parent, false);
                holder.txtFood = (TextView) convertView.findViewById(R.id.txtFood);
                convertView.setTag(holder);
            }else{
                holder = (ViewHolder) convertView.getTag();
            }

            holder.txtFood.setText(foodList.get(position).get("name"));

            return convertView;

        }

        class ViewHolder{
            TextView txtFood;
        }
    }

}