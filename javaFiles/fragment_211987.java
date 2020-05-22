for(String child: children) {
     String pathChild = path;           
     if(!path.equals("/")) { 
         pathChild = path + "/" +  child;
     } else {
         pathChild = path + child;
     }
     //pathChild is used below
     ...
 }