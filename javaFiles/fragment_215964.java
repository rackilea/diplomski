/**
 * {@inheritDoc}
 */
public View getView(int position, View convertView, ViewGroup parent) {
    int sectionnum = 0;
    for(Object section : this.sections.keySet()) {
        Adapter adapter = sections.get(section);
        int size = adapter.getCount() + 1;

        // check if position inside this section
        if(position == 0) return headers.getView(sectionnum, convertView, parent);
        if(position < size){
            View view = adapter.getView(position - 1, convertView, parent);
            TextView captionTV = (TextView) view.findViewById(R.id.list_complex_caption);
            captionTV.setTextColor(R.color.black);
            TextView titleTV = (TextView) view.findViewById(R.id.list_complex_title);
            titleTV.setTextColor(R.color.black);
            return view;
        }

        // otherwise jump into next section
        position -= size;
        sectionnum++;
    }
    return null;
}