@NonNull
@Override
public Filter getFilter() {
    return new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            FilterResults results = new FilterResults();
            if (constraint.length() == 0) {
                results.count = ORIGNAL.size();
                results.values = ORIGNAL;
            } else if (constraint.length() > 0) {
                List<Contact> filtered = new ArrayList<>();
                for (Contact contact : ORIGNAL) {
                    if (contact.getName().toLowerCase().contains(constraint)) {
                        filtered.add(contact);
                    }
                }
                results.count = filtered.size();
                results.values = filtered;
            }
            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            if (constraint.length() == 0) {
                CONTACTS.clear();
                CONTACTS.addAll(ORIGNAL);
            } else if (constraint.length() > 0) {
                CONTACTS.clear();
                CONTACTS.addAll((ArrayList<Contact>) results.values);
            }
            notifyDataSetChanged();
        }
    };
}