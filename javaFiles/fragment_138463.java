String[] stringArray = getResources().getStringArray(R.array.country_arrays)
SharedPreferences sp = getSharedPreferences("My_Prefs", Activity.MODE_PRIVATE); 
int sizeItemSelected= sp.getInt("VALUE", 24);

//if array contains strings if not just make this variable an Int
String sizeToSetTextViewSizeTo = stringArray[sizeItemSelected];
int tvSize = Integer.parseInt(sizeToSetTextViewSizeTo);


TextView titleTV = (TextView) findViewById(R.id.titleTextView);
titleTV.setTextSize(tvSize);