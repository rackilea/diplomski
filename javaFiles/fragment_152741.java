for(int i=0;i<st_jsp.size()&&i<ref_jsp.size();i++){
    Ref_user_interface refObj = ref_jsp.get(i);
    Ref_user_interface stObj = st_jsp.get(i);
    Double x = refObj.getSt1_vs1_bag6_rb();
    Double y = stObj.getSt1_vs1_bag6_rb();
    comparing(x,y);
    x =refObj.getSt1_vs1_bag7_rb();
    y = stObj.getSt1_vs1_bag7_rb();
    comparing(x,y)

     // and so on for all the getters method you have for this obj

     public void comparing(Double x,Double y){
           // write your comparing logic here and add value in map
          if(x > 0 && y > 0){
              if(x>y){
                 z.add(x-y);  
              }else{
                 z.add(y-x); 
              }  
          }else if(x>0){
             z.add(x);
          }else{
             z.add(y);
          }     
     }