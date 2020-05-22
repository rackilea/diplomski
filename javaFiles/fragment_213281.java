else if(a == 3){
       Course course = new Course();
       count = count + 11;
       for(int j = 0; j<10; j++){
           String l = names[(int)(Math.random()*16)];
           course.getClasslist()[j].setName(l);//no casting needed
       }
       array[i]=course;//we can forget the real type of the object now
   }