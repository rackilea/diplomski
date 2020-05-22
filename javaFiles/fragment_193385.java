String str;
 boolean found = false;
 while ((str = in.readLine()) != null) {
       if(str != null && !found){
         found = str.contains("hello") ? true : false;
       }
    }