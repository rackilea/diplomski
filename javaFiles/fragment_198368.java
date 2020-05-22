while (given > 0){
    remainder = given % base;
    if (remainder >= 10){
      switch(remainder){
        case 10:output = "A" + output;break;
        case 11:output = "B" + output;break;
        case 12:output = "C" + output;break;
        case 13:output = "D" + output;break;
        case 14:output = "E" + output;break;
        case 15:output = "F" + output;break;
      }
    } else {
      output = remainder + output;
    }
    given /= base;
}
System.out.println(output);