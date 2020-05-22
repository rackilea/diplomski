private class ActionListAdapter extends ArrayAdapter<BaseListElement> {
    private List<BaseListElement> listElements;

    public ActionListAdapter(Context context, int resourceId, List<BaseListElement> listElements) {
        super(context, resourceId, listElements);
        this.listElements = listElements;
        for (int i = 0; i < listElements.size(); i++) {
            listElements.get(i).setAdapter(this);
        }
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            LayoutInflater inflater =
                    (LayoutInflater) getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.listitem, null);
        }

        BaseListElement listElement = listElements.get(position);
        if (listElement != null) {
            view.setOnClickListener(listElement.getOnClickListener());
            ImageView icon = (ImageView) view.findViewById(R.id.icon);
            TextView text1 = (TextView) view.findViewById(R.id.text1);
            TextView text2 = (TextView) view.findViewById(R.id.text2);
            Button btn = (Button) view.findViewById(R.id.btn_friend);
            if (icon != null) {
                icon.setImageDrawable(listElement.getIcon());
            }
            if (text1 != null) {
                text1.setText(listElement.getText1());
            }
            if (text2 != null) {
                text2.setText(listElement.getText2());
            }
            if (btn != null) {
                // I do not know exactly what text1 and text2 is
                btn.setText(text1 + " waiting for game");
                btn.setOnClickListener(new OnClickListener() {

                    @Override public void onClick(View v) {
                        Toast.makeText(getActivity(), text1+ " " + text2 + " clicked!", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        }
        return view;
    }

}