Bundle extras = getIntent().getExtras();
String var="";
String var1="";
String var2="";
      if (extras != null)
      {

        String value= extras.getString("new_variable_name");       
        value= var;
        String value1= extras.getString("new_variable_name1");
        value1= var1;  

         String value2= extras.getString("new_variable_name2");
         value2= var;
      }