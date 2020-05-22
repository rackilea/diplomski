public class ReportListActivity extends Activity {

    TableLayout srno_table;
    TableRow srno_report_tr_data;

    TableLayout report_table;
    TableRow report_tr_data;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report_list);

        srno_table=(TableLayout) findViewById(R.id.srno_table);

        //---------------Serial no Table Header-----------------------------------------------
        TableRow srno_tr_head = new TableRow(this);
        srno_tr_head.setId(10);
        srno_tr_head.setBackgroundColor(Color.GRAY);
        srno_tr_head.setLayoutParams(new LayoutParams(
        LayoutParams.FILL_PARENT,
        LayoutParams.WRAP_CONTENT));


        TextView label_sr_no = new TextView(this);
        label_sr_no.setId(20);
        label_sr_no.setText("S.No.");
        label_sr_no.setTextColor(Color.WHITE);
        label_sr_no.setPadding(5,5,5,5);
        srno_tr_head.addView(label_sr_no);// add the column to the table row here
        label_sr_no.setTextSize(20);    



        srno_table.addView(srno_tr_head, new TableLayout.LayoutParams(
                LayoutParams.FILL_PARENT,
                LayoutParams.WRAP_CONTENT));

      //---------------Serial no Table Header-----------------------------------------------

        report_table=(TableLayout) findViewById(R.id.report_table);

        //---------------report Table Header-----------------------------------------------
        TableRow report_tr_head = new TableRow(this);
        report_tr_head.setId(10);
        report_tr_head.setBackgroundColor(Color.GRAY);
        report_tr_head.setLayoutParams(new LayoutParams(
        LayoutParams.FILL_PARENT,
        LayoutParams.WRAP_CONTENT));


        TextView label_test_name = new TextView(this);
        label_test_name.setId(20);
        label_test_name.setText("Test Name");
        label_test_name.setTextColor(Color.WHITE);
        label_test_name.setPadding(5,5,5,5);
        report_tr_head.addView(label_test_name);// add the column to the table row here
        label_test_name.setTextSize(20);    

        TextView label_test_date = new TextView(this);
        label_test_date.setId(21);// define id that must be unique
        label_test_date.setText("Date"); // set the text for the header 
        label_test_date.setTextColor(Color.WHITE); // set the color
        label_test_date.setPadding(5,5,5,5); // set the padding (if required)
        report_tr_head.addView(label_test_date); // add the column to the table row here
        label_test_date.setTextSize(20);

        TextView label_ro = new TextView(this);
        label_ro.setId(21);// define id that must be unique
        label_ro.setText("R.O."); // set the text for the header 
        label_ro.setTextColor(Color.WHITE); // set the color
        label_ro.setPadding(5,5,5,5); // set the padding (if required)
        report_tr_head.addView(label_ro); // add the column to the table row here
        label_ro.setTextSize(20);

        TextView label_wo = new TextView(this);
        label_wo.setId(21);// define id that must be unique
        label_wo.setText("W.O."); // set the text for the header 
        label_wo.setTextColor(Color.WHITE); // set the color
        label_wo.setPadding(5,5,5,5); // set the padding (if required)
        report_tr_head.addView(label_wo); // add the column to the table row here
        label_wo.setTextSize(20);

        TextView label_lo = new TextView(this);
        label_lo.setId(21);// define id that must be unique
        label_lo.setText("L.O."); // set the text for the header 
        label_lo.setTextColor(Color.WHITE); // set the color
        label_lo.setPadding(5,5,5,5); // set the padding (if required)
        report_tr_head.addView(label_lo); // add the column to the table row here
        label_lo.setTextSize(20);

        TextView label_max = new TextView(this);
        label_max.setId(21);// define id that must be unique
        label_max.setText("Max."); // set the text for the header 
        label_max.setTextColor(Color.WHITE); // set the color
        label_max.setPadding(5,5,5,5); // set the padding (if required)
        report_tr_head.addView(label_max); // add the column to the table row here
        label_max.setTextSize(20);

        TextView label_tm = new TextView(this);
        label_tm.setId(21);// define id that must be unique
        label_tm.setText("T.M."); // set the text for the header 
        label_tm.setTextColor(Color.WHITE); // set the color
        label_tm.setPadding(5,5,5,5); // set the padding (if required)
        report_tr_head.addView(label_tm); // add the column to the table row here
        label_tm.setTextSize(20);

        TextView label_rank = new TextView(this);
        label_rank.setId(21);// define id that must be unique
        label_rank.setText("Rank"); // set the text for the header 
        label_rank.setTextColor(Color.WHITE); // set the color
        label_rank.setPadding(5,5,5,5); // set the padding (if required)
        report_tr_head.addView(label_rank); // add the column to the table row here
        label_rank.setTextSize(20);


        report_table.addView(report_tr_head, new TableLayout.LayoutParams(
                LayoutParams.FILL_PARENT,
                LayoutParams.WRAP_CONTENT));

      //---------------Serial no Table Header-----------------------------------------------



        //--------------------Sr No Table Body---------------------------
        for (int i=1; i<=10; i++)
        {
            srno_report_tr_data = new TableRow(this);
            srno_report_tr_data.setId(10);
            srno_report_tr_data.setBackgroundColor(Color.TRANSPARENT);
            srno_report_tr_data.setLayoutParams(new LayoutParams(
            LayoutParams.FILL_PARENT,
            LayoutParams.WRAP_CONTENT));


            final TextView sr_no = new TextView(this);
            sr_no.setId(20);
            sr_no.setText(""+i);
            sr_no.setTextColor(Color.BLACK);
            sr_no.setPadding(5,5,5,5);
            srno_report_tr_data.addView(sr_no);// add the column to the table row here





            srno_table.addView(srno_report_tr_data, new TableLayout.LayoutParams(
                    LayoutParams.FILL_PARENT,
                    LayoutParams.WRAP_CONTENT));


            //----------------------On click table row---------------------------------------

            srno_report_tr_data.setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View v) {
                    // TODO Auto-generated method stub


//                  Toast.makeText(getApplicationContext(), test_name.getText().toString(), Toast.LENGTH_LONG).show();
//                  Toast.makeText(getApplicationContext(), test_date.getText().toString(), Toast.LENGTH_LONG).show();
//                  Toast.makeText(getApplicationContext(), sr_no.getText().toString(), Toast.LENGTH_LONG).show();
                    //Toast.makeText(getApplicationContext(), test_exam_set.getText().toString(), Toast.LENGTH_LONG).show();

//                  Intent intent = new Intent(ReportListActivity.this, ReportListDetailsActivity.class);
//                  finish();
//                  ReportListActivity.this.startActivity(intent);
                }
            });
            //----------------------On click table row---------------------------------------



        }

      //--------------------Sr No Table Body Table Body---------------------------





        //=================Report table body============================


        for (int i=1; i<=10; i++)
        {
            report_tr_data=new TableRow(this);
            report_tr_data.setId(10);
            report_tr_data.setBackgroundColor(Color.TRANSPARENT);
            report_tr_data.setLayoutParams(new LayoutParams(
            LayoutParams.FILL_PARENT,
            LayoutParams.WRAP_CONTENT));

            final TextView test_name = new TextView(this);
            test_name.setId(20);
            test_name.setText("Speed Test 60(min) Demo-ST-01");
            test_name.setTextColor(Color.BLACK);
            test_name.setPadding(5,5,5,5);
            report_tr_data.addView(test_name);// add the column to the table row here

            final TextView test_date = new TextView(this);
            test_date.setId(21);// define id that must be unique
            test_date.setText("12 Mar 2013"); // set the text for the header 
            test_date.setTextColor(Color.BLACK); // set the color
            test_date.setPadding(5,5,5,5); // set the padding (if required)
            report_tr_data.addView(test_date); // add the column to the table row here

            final TextView test_ro = new TextView(this);
            test_ro.setId(21);// define id that must be unique
            test_ro.setText("2"); // set the text for the header 
            test_ro.setTextColor(Color.BLACK); // set the color
            test_ro.setPadding(5,5,5,5); // set the padding (if required)
            report_tr_data.addView(test_ro); // add the column to the table row here

            final TextView test_wo = new TextView(this);
            test_wo.setId(21);// define id that must be unique
            test_wo.setText("3"); // set the text for the header 
            test_wo.setTextColor(Color.BLACK); // set the color
            test_wo.setPadding(5,5,5,5); // set the padding (if required)
            report_tr_data.addView(test_wo); // add the column to the table row here

            final TextView test_lo = new TextView(this);
            test_lo.setId(21);// define id that must be unique
            test_lo.setText("85"); // set the text for the header 
            test_lo.setTextColor(Color.BLACK); // set the color
            test_lo.setPadding(5,5,5,5); // set the padding (if required)
            report_tr_data.addView(test_lo); // add the column to the table row here

            final TextView test_max = new TextView(this);
            test_max.setId(21);// define id that must be unique
            test_max.setText("101"); // set the text for the header 
            test_max.setTextColor(Color.BLACK); // set the color
            test_max.setPadding(5,5,5,5); // set the padding (if required)
            report_tr_data.addView(test_max); // add the column to the table row here

            final TextView test_tm = new TextView(this);
            test_tm.setId(21);// define id that must be unique
            test_tm.setText("-1.5"); // set the text for the header 
            test_tm.setTextColor(Color.BLACK); // set the color
            test_tm.setPadding(5,5,5,5); // set the padding (if required)
            report_tr_data.addView(test_tm); // add the column to the table row here

            final TextView test_rank = new TextView(this);
            test_rank.setId(21);// define id that must be unique
            test_rank.setText("5810"); // set the text for the header 
            test_rank.setTextColor(Color.BLACK); // set the color
            test_rank.setPadding(5,5,5,5); // set the padding (if required)
            report_tr_data.addView(test_rank); // add the column to the table row here

            final TextView test_exam_set = new TextView(this);
            test_exam_set.setId(21);// define id that must be unique
            test_exam_set.setText("123456"); // set the text for the header
            test_exam_set.setTextSize((float) 0.01);
            test_exam_set.setTextColor(Color.TRANSPARENT); // set the color
            test_exam_set.setPadding(5,5,5,5); // set the padding (if required)
            report_tr_data.addView(test_exam_set); // add the column to the table row here

            report_table.addView(report_tr_data, new TableLayout.LayoutParams(
                     LayoutParams.FILL_PARENT,
                     LayoutParams.WRAP_CONTENT));



//----------------------On click table row---------------------------------------

            report_tr_data.setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View v) {
                    // TODO Auto-generated method stub


                    Toast.makeText(getApplicationContext(), test_name.getText().toString(), Toast.LENGTH_LONG).show();
//                  Toast.makeText(getApplicationContext(), test_date.getText().toString(), Toast.LENGTH_LONG).show();
//                  Toast.makeText(getApplicationContext(), sr_no.getText().toString(), Toast.LENGTH_LONG).show();
                    Toast.makeText(getApplicationContext(), test_exam_set.getText().toString(), Toast.LENGTH_LONG).show();

//                  Intent intent = new Intent(ReportListActivity.this, ReportListDetailsActivity.class);
//                  finish();
//                  ReportListActivity.this.startActivity(intent);
                }
            });
            //----------------------On click table row---------------------------------------

        }


      //=================Report table body============================





    }
    //onclick device back button
    @Override
    public void onBackPressed() {
        // do something on back.

        Intent intent = new Intent(ReportListActivity.this, TakeTestActivity.class);
        finish();
        ReportListActivity.this.startActivity(intent);
        return;
    }


  //method to show toast message
        public void makeAToast(String str) {
            //yet to implement
            Toast toast = Toast.makeText(this,str, Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER, 0, 0);
            toast.show();
        }
}