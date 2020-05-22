@Override
public View getView (int position, View convertView, ViewGroup parent) {
    View vi;
    if (convertView != null) {
        // view was already created, reuse what i have
        vi = convertView;
    } else {
        // no view available, create new one
        // always provide parent view, but don't attach to view hierarchy
        vi = inflater.inflate(R.layout.property_result_item, parent, false);
    }

    // this is ineffective, google ViewHolder
    TextView address = (TextView) vi.findViewById(R.id.propertyAddress);
    TextView city = (TextView) vi.findViewById(R.id.propertyCity);
    TextView owners = (TextView) vi.findViewById(R.id.propertyOwner);
    TextView apn = (TextView) vi.findViewById(R.id.propertyAPN);

    // only retrieve data associated with currently asked position
    // don't keep calling get() all the time, that's wasteful
    PropertyInformationValues values = data.get(position);

    // assign values
    address.setText(values.getAddress1() + " " + values.getAddress2());
    city.setText(values.getCity() + ", " + values.getState() + " " + values.getZip());
    owners.setText(values.getOwner());
    apn.setText(values.getApn());

    // return loaded view
    return vi;
}