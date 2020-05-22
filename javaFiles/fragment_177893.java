@Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;
        if (v == null) {
            LayoutInflater inflater = (LayoutInflater) ctx
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inflater.inflate(R.layout.your_custom_item, null);
        }

        if(selectedItems.get(position))
            v.setBackgroundColor("YOURSELECTEDCOLOR");
        else v.setBackgroundColor("YOURUNSELECTEDCOLOR");

        return v;
    }