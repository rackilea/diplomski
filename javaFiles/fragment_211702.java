public class MyContactAdapter2 extends BaseAdapter {
    List<EffectList> contacts;
    Context context;
    private LayoutInflater mInflater;


    // Constructors
    public MyContactAdapter2(Context context, List<Map<String, List<EffectList>>> objects) {

    this.context = context;
    this.mInflater = LayoutInflater.from(context);
    this.contacts = new ArrayList<>();
    Map<String, List<EffectList>> map = objects.get(0);
    Set<String> keySet = map.keySet();
    Iterator<String> iterator = keySet.iterator();
    while (iterator.hasNext()) {
        this.contacts.addAll(map.get(iterator.next()));
    }
}

    public MyContactAdapter2() {
        System.out.println("hai");
    }

    @Override
    public int getCount() {
        int count = contacts.size();
        return count;
    }

    @Override
    public EffectList getItem(int position) {
        return contacts.get(position);
    }


    @Override
    public long getItemId(int position) {
        return 0;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        System.out.println(10);


        final MyContactAdapter2.ViewHolder vh;
        if (convertView == null) {
            View view = mInflater.inflate(R.layout.get_layout_row_view, parent, false);
            vh = MyContactAdapter2.ViewHolder.create((RelativeLayout) view);
            view.setTag(vh);

        } else {
            vh = (MyContactAdapter2.ViewHolder) convertView.getTag();
        }
            EffectList item = getItem(position);

            vh.textViewName.setText(item.getEffectsId());
            vh.textViewEmail.setText(item.getEffectsName());


        return vh.rootView;
    }


    private static class ViewHolder {
        public final RelativeLayout rootView;
        public final ImageView imageView;
        public final TextView textViewName;
        public final TextView textViewEmail;

        private ViewHolder(RelativeLayout rootView, ImageView imageView, TextView textViewName, TextView textViewEmail) {
            this.rootView = rootView;
            this.imageView = imageView;
            this.textViewName = textViewName;
            this.textViewEmail = textViewEmail;
        }

        public static MyContactAdapter2.ViewHolder create(RelativeLayout rootView) {
            ImageView imageView = (ImageView) rootView.findViewById(R.id.imageView);
            TextView textViewName = (TextView) rootView.findViewById(R.id.textViewName);
            TextView textViewEmail = (TextView) rootView.findViewById(R.id.textViewEmail);
            return new MyContactAdapter2.ViewHolder(rootView, imageView, textViewName, textViewEmail);
        }
    }
}