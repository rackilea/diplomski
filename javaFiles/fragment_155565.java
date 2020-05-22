private class SchemeAdapter extends ArrayAdapter<String> {

    private int layout;

    public SchemeAdapter(final Context context, final List<String> objects) {
        //row layout id, content view id
        super(context, R.layout.list_row_practice, R.id.list_row_practice_name,
                objects);

        layout = R.layout.list_row_practice;
    }

    @Override
    public View getView(final int position, final View convertView, final ViewGroup parent) {
        final View row =
                (convertView == null) ? getLayoutInflater().inflate(layout, parent, false) :
                        convertView;

        if (row != null) {
            final TextView name = (TextView) row.findViewById(R.id.list_row_practice_name);
            //set here your text, image view src and radio button value.
        }
        return row;
    }