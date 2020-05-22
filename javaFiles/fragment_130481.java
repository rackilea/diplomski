class HangarAdapter extends ArrayAdapter<String> {

     //shipDesc below is the second string array.
        String[] shipDesc = {"10 Planets Every 5 Secs \n 100$",
                "50 Planets Every 5 Secs \n 500$",
                "100 Planets Every 5 Secs \n 1500$",
                "500 Planets Every 4 Secs \n 3000$",
                "1000 Planets Every 4 Secs \n 7500$",
                "5000 Planets Every 4 Secs \n 15000$",
                "10000 Planets Every 3 Secs \n 50000$",
                "30000 Planets Every 3 Secs \n 100000$",
                "60000 Planets Every 3 Secs \n  500000$",
                "100000 Planets Every 1 Secs \n 1000000$"};


    public HangarAdapter(Context context,String[] values) {
        super(context, R.layout.hangar_layout, values);

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater theInflater = LayoutInflater.from(getContext());

        View theView = theInflater.inflate(R.layout.hangar_layout, parent, false);

        TextView TextView1 = (TextView) theView.findViewById(R.id.textView1);


        //TextView2 Is the text view i want the second string array to go into
        TextView TextView2 = (TextView) theView.findViewById(R.id.textView2);

        TextView1.setText(getItem(position));
        TextView2.setText(shipDesc[position])

        ImageView theImageView = (ImageView) theView.findViewById(R.id.imageView);

        return theView;
        }