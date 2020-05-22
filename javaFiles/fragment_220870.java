for(int i=0;i<20;i++)
    stack.push(rnd.nextInt(101));

int numberOfZeros=0;
while(!stack.isEmpty()) {
    int value = stack.pop(), x = value % 3;
    if(x == 0) numberOfZeros++;
    else if(x == 1) stack4.push(x);
    else if(x == 2) stack3.push(x);
    stack2.push(value);// use stack2 as temporary storage
}
while(!stack2.isEmpty()) stack.push(stack2.pop()); // transfer back
for(;numberOfZeros>0; numberOfZeros--) stack2.push(0);