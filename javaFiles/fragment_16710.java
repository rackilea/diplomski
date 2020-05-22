@Override
public View getView(int position, View convertView, ViewGroup container {

    Entry entry = getItem(position);

    if (convertView == null) {
        convertView = LayoutInflater.from(getContext())
            .inflate(R.layout.activity_create_event, container, false);
    }

...