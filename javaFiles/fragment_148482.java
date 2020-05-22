int i = 0;

while (product.charAt(i) == '0' && i < product.length() - 1)
    i++;

System.out.println( product.substring(i) );