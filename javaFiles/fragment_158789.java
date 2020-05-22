class CustomArrayAdapter extends ArrayAdapter {
    CustomArrayAdapter() {
        super(YourActivity.this, R.layout.message);
    }

    public View getView(int position, View convertView,
                                            ViewGroup parent) {
        View row=convertView;

        if (row==null) {                                                    
            LayoutInflater inflater=getLayoutInflater();

            row=inflater.inflate(R.layout.message, parent, false);
        }

        // e.g. if you have a TextView called in your row with ID 'label'
        TextView label=(TextView)row.findViewById(R.id.label);
        label.setText(items[position]);

        // check the state of the row maybe using the variable 'position'
        if( I do not actually know whats your criteria to change style ){
            label.setTextColor(blablabla);
        }

        return(row);
    }
}