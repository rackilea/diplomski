public String apply(Vector args) 
{
    //define two string variables
    String expString1 = (String)args.get(0);
    String expString2 = (String)args.get(1);
    String s = "";

    //move the x if the last char is x.
     if (expString1.charAt(expString1.length()-1) == 'x'){
         s = expString1.substring(0, expString1.length()-1);
     }else if (expString1.charAt(expString1.length()-1) != 'x') {
         s = expString1;}
     //convert string to int, and do the divide operator.
     int n2 = Integer.parseInt(expString2);
     int n1 = Integer.parseInt(s);
     int div = n1 / n2;
     //this is what i add, to check is the expString1 has a x.
     String result = String.valueOf(div);
     if (expString1.contains("x")) { return result = result + "x"; }
     else  return result;


}