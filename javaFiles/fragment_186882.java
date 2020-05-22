public class ModelAdapter extends ArrayAdapter<Model> {

        private ArrayList<Model> data;

        public ModelAdapter(Context context, int resource,
                int textViewResourceId, ArrayList<Model> objects) {
            super(context, resource, textViewResourceId, objects);
            data = objects;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            // let the adapter bind the name to the list
            View v = super.getView(position, convertView, parent);
            // find the counter TextView so we can update it's value
            TextView counterTv = (TextView) v.findViewById(R.id.counter);
            //get the data from the list for this row.
            Model obj = data.get(position);
            //set the counter value for this row
            counterTv.setText(String.valueOf(obj.counter));
            return v;
        }       

    }