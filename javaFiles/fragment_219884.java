@Override
    public View getGroupView(int groupPosition, boolean isExpanded,
                             View convertView, ViewGroup parent) {
        String headerTitle = (String) getGroup(groupPosition);
        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) this._context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.list_group, null);
        }

        ImageView lblListHeader = (ImageView) convertView.findViewById(R.id.lblListHeader);

        ImageView iconaModifica= (ImageView) convertView.findViewById(R.id.icona_modifica);
        iconaModifica.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mMyInterface.onClickIconaModifica(groupPosition, isExpanded, convertView, parent)
            }
        });

        return convertView;
    }