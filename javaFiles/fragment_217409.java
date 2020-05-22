private String data;

onCreate(Bundle savedInstanceState){
    ....
    btn_outbox.setOnClickListener(this);

    ....
    DatePickerDialog.OnDateSetListener d = new DatePickerDialog.OnDateSetListener(){

        public int Syear;
        public int Smonth;

        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear,
                int dayOfMonth) {
            // Do what you need to, data string works here

        }

    };
}


onClick(View v){
    data = "some string";
}