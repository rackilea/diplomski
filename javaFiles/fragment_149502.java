public void onClick(View v){
    switch(v.getId())
    {
       case R.id.grey:
           tv1.setTextColor(Color.RED);
       break;
        case R.id.white:
           tv1.setTextColor(Color.BLUE);
       break;
    } 

}