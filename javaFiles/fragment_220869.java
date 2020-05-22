for(int i=0;i<20;i++) {
    final int value = rnd.nextInt(101), x=value%3;
    stack.push(value);
    if(x == 0) stack2.push(x);
    else if(x == 1) stack4.push(x);
    else if(x == 2) stack3.push(x);
}