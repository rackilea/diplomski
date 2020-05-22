private Integer getNumber(EditText editText){
     int num = 0;
     if(editText == null) {
       Log.e("YouApp", "Didnt find view");
       return num;
     }
     String input = editText.getText().toString();
     if(!"".equals(input)) {
        try{
           num = Integer.parseInt(input);
        } catch(NumberFormatException e){
          Log.("YouApp", "Invalid input: "+input, e);
        }
     }
     return num;
}