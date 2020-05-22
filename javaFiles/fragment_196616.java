if (forms!= null) {
   for (Map.Entry<String, Object> form : forms.entrySet()) {
       String key = form.getKey();
       if(key.contains("Form")) {
           Map<Object, Object> values = (Map<Object, Object>) form.getValue();
           name = (String) values.get("name");
           String id = (String) values.get("id");
           Log.d("nesteddata", name + "......" + id + "......." + key);
           if (key.contains("Form1")) {                               
               shared_menueditor.putString("nav_form1",name);
           }
           if (key.contains("Form2")) {                  
               shared_menueditor.putString("nav_form2",name);
           }
           if (key.contains("Form3")) {                             
               shared_menueditor.putString("nav_form3",name);
           }
         }
       }

   }