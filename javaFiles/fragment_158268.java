public class lst extends Fragment {

    String URL = "URL HERE";
    static final String KEY_COUPON = "coupon"; // parent node
    static final String KEY_ID = "id";
    private boolean onCreateRunned = false;
    ArrayList<HashMap<String, String>> list;

    ListView list;
    LazyAdapter adapter;

    @Override
      public View onCreateView(LayoutInflater inflater, ViewGroup container,
              Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.list,
                container, false); 



        list = new ArrayList<HashMap<String, String>>();
        new Thread(new Runnable(){
        public void run() {

        XMLParser parser = new XMLParser();
        String xml = parser.getXmlFromUrl(URL);
        Document doc = parser.getDomElement(xml);

        NodeList nl = doc.getElementsByTagName(KEY_COUPON);
        for (int i = 0; i < nl.getLength(); i++) {
            HashMap<String, String> map = new HashMap<String, String>();
            Element e = (Element) nl.item(i);
            map.put(KEY_ID, parser.getValue(e, KEY_ID));
            list.add(map);
        }

        //Maybe this must activity.runOnUiThread(...     
        list=(ListView) view.findViewById(R.id.list);

        adapter= new LazyAdapter(getActivity(), list);        
        list.setAdapter(adapter);

        }}).start()


        return view;


    }   

}