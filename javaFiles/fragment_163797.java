public class MainListAdapter extends ArrayAdapter<String> {
...
Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = ((Activity) mycontext).getLayoutInflater();
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.list_main_view_item, null);
            assert convertView!=null;
            Switch s = (Switch)convertView.findViewById(R.id.switch1);
            assert s!=null;
            s.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Log.w("MiniTasker", "adapter w00t " + Integer.toString(view.getId()));
                }
            });
        }
        return super.getView(position, convertView, parent);
    }
}