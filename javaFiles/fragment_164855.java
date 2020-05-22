@Override
public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,
        long arg3) {  
    String s1= spinner1.getSelectedItem().toString();
    mCallback.onValueSelected(s1);
    }