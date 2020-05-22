@Override
public View getView(int position, View convertView, ViewGroup parent) {
    View view = View.inflate(context, R.layout.cell, null);
    view.setClickable(true);
    view.setFocusable(true);
    view.setBackgroundResource(android.R.drawable.menuitem_background);
    view.setOnClickListener(new OnClickListener() {

        @Override
        public void onClick(View v) {
            new AlertDialog.Builder(context).setTitle("touched").show();
        }

    });
    return view;
}