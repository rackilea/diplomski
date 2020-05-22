@Override
public View getView(int position, View convertView, ViewGroup container {

    Entry entry = getItem(position);

    if (convertView == null) {
        convertView = LayoutInflater.from(getContext())
            .inflate(R.layout.list_row, container, false);
    }

...