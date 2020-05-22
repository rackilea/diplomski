String[] strings = {"Somelist", "SOmelist"};

Spinner spinner = (Spinner) findViewById(R.id.spinner1);
        spinner.setAdapter(new MyAdapter(this, R.layout.row, strings));

....    

public class MyAdapter extends ArrayAdapter<String> {

            public MyAdapter(Context context, int textViewResourceId,
                    String[] objects) {

                super(context, textViewResourceId, objects);

            }

            @Override
            public View getDropDownView(int position, View convertView,
                    ViewGroup parent) {

                return getCustomView(position, convertView, parent);

            }

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {

                return getCustomView(position, convertView, parent);

            }

            public View getCustomView(int position, View convertView,
                    ViewGroup parent) {

                LayoutInflater inflater = getLayoutInflater();

                View row = inflater.inflate(R.layout.row, parent, false);

                TextView label = (TextView) row.findViewById(R.id.company);

                label.setText(strings[position]);

                TextView sub = (TextView) row.findViewById(R.id.sub);

                sub.setText(subs[position]);

///You can have different combinations on which items in the list you want to change background, text or anything else

                if (position % 2 == 0) {
                    label.setTextColor(Color.BLUE);
                    row.setBackgroundColor(Color.RED);
                }

                return row;

            }

        }