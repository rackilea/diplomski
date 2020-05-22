listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
      String value="";
      if(!TextUtils.isEmpty(buttonType) && buttonType.equals("A")) {
          value=FRUITS[position];
       } else if(!TextUtils.isEmpty(buttonType) && buttonType.equals("B")) {
          value=NAMES[position];
       }
     // you can get value in "value"
       showToast(value);
    }
});
public void showToast(String value) {

    Toast.makeText(this,value, Toast.LENGTH_LONG).show();

}