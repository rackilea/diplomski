class Adder {
  private int base;
  private int[] a;
  private int[] b;
  private int[] sum;

  public String add() {
    int digitCt= a.length;
    if(b.length>digitCt)
      digitCt= b.length;        //max(a,b)
    digitCt+= 1;                //Account for possible carry
    sum= new int[digitCt];      //Allocate space
    int digit= 0;               //Start with no carry
    //Add each digit...
    for(int nDigit=0;nDigit<digitCt;nDigit++) {
      //digit already contains the carry value...
      if(nDigit<a.length)
        digit+= a[nDigit];
      if(nDigit<b.length)
        digit+= b[nDigit];
      sum[nDigit]= digit % base;//Write LSB of sum
      digit= digit/base;        //digit becomes carry
    }
    return(arrayToText(sum));
  }

  public Adder(int _base) {
    if(_base<1) {
      base= 1;
    } else if(_base>36) {
      base=36;
    } else {
      base= _base;
    }
    a= new int[0];
    b= new int[0];
  }

  public void loadA(String textA) {
    a= textToArray(textA);
  }

  public void loadB(String textB) {
    b= textToArray(textB);
  }

  private int charToDigit(int digit) {
    if(digit>='0' && digit<='9') {
      digit= digit-'0';
    } else if(digit>='A' && digit<='Z') {
      digit= (digit-'A')+10;
    } else if(digit>='a' && digit<='z') {
      digit= (digit-'a')+10;
    } else {
      digit= 0;
    }
    if(digit>=base)
      digit= 0;
    return(digit);
  }

  private char digitToChar(int digit) {
    if(digit<10) {
      digit= '0'+digit;
    } else {
      digit= 'A'+(digit-10);
    }
    return((char)digit);
  }

  private int[] textToArray(String text) {
    int digitCt= text.length();
    int[] digits= new int[digitCt];
    for(int nDigit=0;nDigit<digitCt;nDigit++) {
      digits[nDigit]= charToDigit(text.charAt(nDigit));
    }
    return(digits);
  }

  private String arrayToText(int[] a) {
    int digitCt= a.length;
    StringBuilder text= new StringBuilder();
    for(int nDigit=0;nDigit<digitCt;nDigit++) {
      text.append(digitToChar(a[nDigit]));
    }
    return(text.toString());
  }

  public long textToInt(String a) {
    long value= 0;
    long power= 1;
    for(int nDigit=0;nDigit<a.length();nDigit++) {
      int digit= charToDigit(a.charAt(nDigit));
      value+= digit*power;
      power= power*base;
    }
    return(value);
  }
}

public class digits {

  public static void main(String args[]) {
    System.out.println("NOTE: Values are Little-Endian! (right-to-left)");
    System.out.println(test(1,"0","00"));
    System.out.println(test(2,"01","1"));
    System.out.println(test(2,"11","01"));
    System.out.println(test(2,"11","011"));
    System.out.println(test(16,"0A","16"));
    System.out.println(test(32,"0R","15"));
  }

  public static String test(int base, String textA, String textB) {
    Adder adder= new Adder(base);
    adder.loadA(textA);
    adder.loadB(textB);
    String sum= adder.add();
    String result= String.format(
      "base%d: %s(%d) + %s(%d) = %s(%d)",
       base,
       textA,adder.textToInt(textA),
       textB,adder.textToInt(textB),
       sum,adder.textToInt(sum)
    );
    return(result);
  }

}