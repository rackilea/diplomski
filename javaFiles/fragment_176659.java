public static class CounterDialog extends AlertDialog.Builder{
    private TextView textView;

    public CounterDialog(Context context) {
        super(context);

        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.dialog, null);
        setView(view);

        setTitle("mytitile!");

        textView = (TextView)view.findViewById(R.id.textView);

        Button button = (Button)view.findViewById(R.id.button);
        button.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View arg0) {
                textView.setText("click me!!!");


            }
        });
    }     

}