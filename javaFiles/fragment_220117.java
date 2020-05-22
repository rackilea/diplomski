while(true) { // << always true ;P

    BigInteger temp = var.add(var2);
    var = var2;
    var2 = temp;
    counter++;

    if(var.toString().length() > 1000) {
        System.out.print(counter);
    }
}