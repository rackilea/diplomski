public class CustomAdapter extends SimpleAdapter {
        private LayoutInflater mInflater;
        private List<HashMap<String, String>> mItems = null;
        private Context mContext;

        private OnClickListener mClick;
        private OnCheckedChangeListener mChecked;

        public CustomAdapter(Context context, List<HashMap<String, String>> items, int resource, String[] from, int[] to) {
            super(context, items, resource, from, to);
            mInflater = LayoutInflater.from(context);
            mItems = items;
            mContext = context;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) { 
            ViewHolder holder;

            if (convertView == null) {
                convertView = mInflater.inflate(R.layout.custom_row_view, null);

                holder = new ViewHolder();
                holder.chkbxEstado = (CheckBox) convertView.findViewById(R.id.chkbxCompletado);
                holder.txtTextoAgenda = (TextView) convertView.findViewById(R.id.txtTextoLista);
                holder.posicion = position; //Add the new position into the holder for each row.

                convertView.setTag(holder);

                mClick = new OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ViewHolder viewHolder = getViewHolder(v); //Get the ViewHolder for the clicked row.
                        Log.i("Posicion",""+v.posicion);
                    }
                };

                mChecked = new OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        ViewHolder viewHolder = getViewHolder(buttonView); //Get the ViewHolder for the clicked CheckBox
                        Log.i("Posicion",""+viewHolder.posicion);
                    }
                };

            } else {
                holder = (ViewHolder) convertView.getTag();
            }

            holder.txtTextoAgenda.setText(mItems.get(position).get("descripcion"));

            convertView.setOnClickListener(mClick);

            holder.chkbxEstado.setOnCheckedChangeListener(mChecked);

            return convertView;

        }

        public ViewHolder getViewHolder(View v){ //This method returns the ViewHolder stored in the tag if available, if not it recursively checks the parent's tag.
            if(v.getTag() == null){
                return getViewHolder((View)v.getParent());
            }
            return (ViewHolder)v.getTag();
        }

        private static class ViewHolder {
            TextView txtTextoAgenda;
            CheckBox chkbxEstado;
            int posicion; //Added position attribute to ViewHolder class.
        }
    }