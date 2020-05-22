if(row == null){
            LayoutInflater layoutInflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = layoutInflater.inflate(R.layout.row_layout,parent,false);
            contactHolder = new ContactHolder();
            contactHolder.tx_id = (TextView)row.findViewById(R.id.tx_id);
            contactHolder.tx_firstname = (TextView)row.findViewById(R.id.tx_firstname);
            contactHolder.tx_surname = (TextView)row.findViewById(R.id.tx_surname);
            contactHolder.tx_username = (TextView)row.findViewById(R.id.tx_username);
            contactHolder.tx_password = (TextView)row.findViewById(R.id.tx_password);
            row.setTag(contactHolder);