final TextView cur_text = (TextView) findViewById(R.id.current_num);
add_one.setOnClickListener(new OnClickListener() { 
    public void onClick(View v) { 
        current_number += 1;
        cur_text.setText(Integer.toString(current_number);
    } 
});