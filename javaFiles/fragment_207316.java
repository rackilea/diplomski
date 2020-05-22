StringBuilder strBuilder = new StringBuilder("john,mary,paul,bla,etc,");

int prevIndex = strBuilder.indexOf("etc");

strBuilder.replace(prevIndex-1, prevIndex, " and ");

int nextIndex = strBuilder.indexOf("etc");

strBuilder.replace(nextIndex+3, nextIndex+4, ".");

System.out.println("Result: "+strBuilder.toString());