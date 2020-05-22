if(!( (number.get(i)) % 3==0) || ( (number.get(i)) % 5==0) ){
    temp=String.valueOf(number.get(i));
    numfb.add(i,temp);
  }
  else if( (number.get(i)) % 5==0 && (number.get(i)) % 3==0 ){
    numfb.add(i,"FizzBuzz");
  }
  else if( (number.get(i) ) %3 == 0){
    numfb.add(i,"Fizz");
  }
  else if( (number.get(i) ) % 5 == 0 ){
    numfb.add(i,"Buzz");
  }