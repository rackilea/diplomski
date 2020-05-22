public class AdapterSpinner extends ArrayAdapter<String> {

    public AdapterSpinner(@NonNull Context context) {
        super(context, 0);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        convertView = LayoutInflater.from(getContext()).inflate(R.layout.spinner_layout, null);
        TextView txv = (TextView) convertView.findViewById(R.id.txt1);

        String text = getItem(position);
        txv.setText(text);

        return convertView;
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        convertView = LayoutInflater.from(getContext()).inflate(R.layout.spinner_layout, null);
        TextView txv = (TextView) convertView.findViewById(R.id.txt1);

        String text = getItem(position);
        txv.setText(text);

        return convertView;
    }
}