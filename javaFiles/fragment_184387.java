while((text = input.readLine()) != null){
       //gets rid of places 
if !(a.contains("Place")){
           text = text.replaceAll("Name:", "");
           names.add(new Name(text));
         }
    }