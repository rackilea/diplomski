public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater mInflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            convertView = mInflater.inflate(R.layout.fragment_row_itempair, null);
        }       

        TextView txtKey = (TextView) convertView.findViewById(R.id.txtKey);
        TextView txtValue = (TextView) convertView.findViewById(R.id.txtValue);

        info.android.model.ItemPair ip = getItem(position);

        if (ip != null)
        {
            if (ip.Key != null) txtKey.setText(ip.Key);
            if (ip.Value != null) txtValue.setText(ip.Value);
        }


        convertView.setTag(ip.Key);


        return convertView;
    }