@Override
public Filter getFilter() {

    Filter filter = new Filter() {

        @SuppressWarnings("unchecked")
        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {

        currencyList = (ArrayList<HashMap<String,String>>) results.values; 

            notifyDataSetChanged();
        }

        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            FilterResults results = new FilterResults(); 
            ArrayList<HashMap<String, String>> FilteredArrList = new ArrayList<HashMap<String, String>>();

            if (mOriginalValues == null) {
                mOriginalValues = new ArrayList<HashMap<String, String>>(currencyList); // saves

            }


            if (constraint == null || constraint.length() == 0) {

                // set the Original result to return
                results.count = mOriginalValues.size();
                results.values = mOriginalValues;
            } else {
                Locale locale = Locale.getDefault();
                constraint = constraint.toString().toLowerCase(locale);
                for (int i = 0; i < mOriginalValues.size(); i++) {
                       HashMap<String, String> currency = mOriginalValues.get(i);
                    String data = currency.get("name");
                    if (data.toLowerCase(locale).startsWith(constraint.toString())) {

                        FilteredArrList.add(currency);
                    }

                }
                // set the Filtered result to return
                results.count = FilteredArrList.size();
                results.values = FilteredArrList;

            }
            return results;
        }
    };
    return filter;
}