if (obj instanceof Node[]){
     // do something
 }
 else if (obj instanceof String) { 
     // do something
 }
 else {
    throw new IOException("unexpected object in data stream "+ obj);
 }