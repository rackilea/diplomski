boolean areAllNull = true;
for (int i = 0; i < col.length; i ++) {
   if (col[i] != null) { 
       areAllNull = false;
       break;
   }
}

if (areAllNull) {
    //statement 
}