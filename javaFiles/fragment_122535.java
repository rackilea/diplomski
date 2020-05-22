while(rs.next()){
   String a = rs.getString('SORTER');
   if('1'.equals(a)){ 
     if(/*RepSubstring.equals('Spring')*/){ listSpring.add(rs.getRow());}
     else if(/*RepSubstring.equals('Winter')*/){listWinter.add(rs.getRow());}   
     else{list.add(rs.getRow());}
   }
}