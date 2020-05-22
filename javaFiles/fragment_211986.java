for(String child: children) {           
     if(!path.equals("/")) { 
         path = path + "/" +  child;
     } else {
         path = path + child;
     }
     ...
 }