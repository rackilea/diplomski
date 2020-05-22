@NonNull
@Override
public Filter getFilter() {
    return nameFilter;
}

/*
 * Custom Filter implementation for custom suggestions we provide.
 */
private Filter nameFilter = new Filter() {
    @Override
    protected FilterResults performFiltering(CharSequence inputChars) {

        if (inputChars != null) {

            try {
                suggestions.clear();
            } catch (Exception e) {
                e.printStackTrace();
            }

            for (String acTvItem : tempItems) {
                if (acTvItem.toLowerCase().contains(inputChars.toString().toLowerCase())) {
                    suggestions.add(acTvItem);
                }
            }

            FilterResults filterResults = new FilterResults();
            filterResults.values = suggestions;
            filterResults.count = suggestions.size();
            return filterResults;
        } else {
            return new FilterResults();
        }
    }

    @Override
    protected void publishResults(CharSequence constraint, FilterResults results) {
        List<String> filterList = (ArrayList<String>) results.values;
        if (results.count > 0) {
            clear();
            if (filterList != null && !filterList.isEmpty()) {

                for (String acTvItem : filterList) {

                if (listener != null && acTvItem.equalsIgnoreCase(inputChars.toString()) && results.count == 1) {
                    listener.onCompleteInputListener(key);
                }

                    add(acTvItem);
                    notifyDataSetChanged();
                }
            }
        }
    }
};


/*  ---------- Interface ----------  */

public interface CompleteInputListener {
    void onCompleteInputListener(String key);
}