public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // initial the arraylist
        List<Animal> animals = new ArrayList<Animal>() {{
            add(new Dog());
            add(new Cat());
        }};
        // get a list view
        ListView listView = (ListView) findViewById(R.id.list_view);
        listView.setAdapter(new MyAdapter(animals));
    }

    // this is your custom adapter
    static class MyAdapter<Animal> extends BaseAdapter {

        private List<Animal> animalList;

        public MyAdapter(List<Animal> animalList) {
            this.animalList = animalList;
        }

        @Override
        public int getCount() {
            return animalList.size();
        }

        @Override
        public Animal getItem(int position) {
            return animalList.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            Animal animal = getItem(position);
            if(animal instanceof Dog){
                // do dog things
            }else if(animal instanceof Cat){
                // do cat things
            }
            // you might want inflate your custom item view at here
            return null;
        }
    }

    static interface Animal {
        // customize your interface as you wish
    }

    static class Cat implements Animal {

    }

    static class Dog implements Animal {

    }
}