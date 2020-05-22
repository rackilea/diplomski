@Override
public int compareTo(Gyumi t) {
   if(termekkod.compareTo(t.gettermekkod())>0){
       return 1;
   }
   if(termekkod.compareTo(t.gettermekkod())<0){
       return -1;
   }
       return 0;
 }