public final class PointVerificationAdapter extends BaseAdapter {
    List<BasicNameValuePair> mObjects;
    Context mContext;
    LayoutInflater mInflater;
    HashMap<Integer, String> mReponsesActuel;
    ArrayList<String> myItems = new ArrayList<String>();

    public PointVerificationAdapter(
            Context context,
            List<BasicNameValuePair> listObjets
            ) {

        this.mInflater = LayoutInflater.from(context);
        this.mContext = context;
        this.mObjects = listObjets;

        for (int i = 0; i < 30; i++) {
            myItems.add(Integer.toString(i));
        }
    }

    @Override
    public int getCount() {
        return mObjects.size();
    }

    @Override
    public BasicNameValuePair getItem(int position) {
        return mObjects.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    static class ViewHolder {
        EditText yourEditText;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder = null;

        if (convertView == null)
        {
            holder = new ViewHolder();
            convertView = mInflater.inflate(R.layout.intervention_reponses_controle_nombre, parent, false);
            convertView.setId(position);
            holder.yourEditText = (EditText) convertView.findViewById(R.id.edValeur);

            convertView.setTag(holder);
        }
        else
        {
            holder = (ViewHolder) convertView.getTag();
        }

        ((TextView) convertView.findViewById(R.id.tvNom)).setText(Integer.toString(position));

        holder.yourEditText.setText(myItems.get(position));
        holder.yourEditText.setId(position);
        holder.yourEditText.setOnFocusChangeListener(new OnFocusChangeListener() {
            public void onFocusChange(View view, boolean hasFocus) {
                if (!hasFocus){
                    final int position = view.getId();
                    final EditText editText = (EditText) view;
                    myItems.set(position, editText.getText().toString());
                }
            }
        });

        return convertView;
    }

}