public class MedicinesAdapter extends ArrayAdapter<Medicine> {
    public MedicinesAdapter(Context context, ArrayList<Medicine> medicines) {
        super(context, 0, medicines);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Medicine medicine = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }
        TextView medicineTextView = (TextView) convertView.findViewById(R.id.medicineTextView);
        TextView doseTextView = (TextView) convertView.findViewById(R.id.doseTextView);
        .... // Lookup  the rest of views for data population

        medicineTextView.setText(medicine.getName());
        doseTextView.setText(medicine.getDose());
        ... // Populate the rest of the views 
        return convertView;
    }
}