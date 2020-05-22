@Override
public void onItemClick(AdapterView<?> arg0, View position, int arg2, long arg3) {

        Intent i;
        if( position == 1 ){           
            i = new Intent(listV.this, MyFirstActivity.class);
        } else if (position == 2){           
            i = new Intent(listV.this, MySecondActivity.class);
        } else if (position == 3) {
            i = new Intent(listV.this, MyThirdActivity.class);
        } else {
            return;
        }           
        startActivity(i);

}