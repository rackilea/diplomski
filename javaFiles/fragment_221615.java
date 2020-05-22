public class MyBaseAdapter extends BaseAdapter {

// Other methods of extends BaseAdapter
...

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        MyViewHolder mViewHolder;

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.zlecenia_lista, parent, false);
            mViewHolder = new MyViewHolder(convertView);
            convertView.setTag(mViewHolder);
        } else {
            mViewHolder = (MyViewHolder) convertView.getTag();
        }

        ListData currentListData = getItem(position);

        mViewHolder.strefa.setText(currentListData.getStrefa());
        mViewHolder.adres.setText(currentListData.getAdres());
        mViewHolder.data.setText(currentListData.getData());
        // try this
        if(currentListData.getData().equals("")) {
              convertView.setVisibility(View.GONE) // all the row is hided
        }else {
              convertView.setVisibility(View.VISIBLE) // display the row
        }
        return convertView;
    }

    private class MyViewHolder {
        TextView strefa, adres, data;

        public MyViewHolder(View item) {
            strefa = (TextView) item.findViewById(R.id.strefa);
            adres = (TextView) item.findViewById(R.id.adres);
            data = (TextView) item.findViewById(R.id.data);
        }
    }

}