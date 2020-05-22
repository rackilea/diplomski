public CustomAdaptor_InputSliders(Context context, String[] resource) {
        super(context, R.layout.input_slider_01, resource);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater Inflater = LayoutInflater.from(getContext());
        View customView = Inflater.inflate(R.layout.input_slider_01, parent, false);

        String singleViewItem = getItem(position);
        TextView title = (TextView) customView.findViewById(R.id.textView5);
        SeekBar seekbar = (SeekBar) customView.findViewById(R.id.seekBar2);

        title.setText(singleViewItem);


        seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {


            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {


            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar bar) {
                progressValue = bar.getProgress();

            }
        });


        return customView;
    }


}