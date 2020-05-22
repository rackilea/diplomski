boolean hasFactor = false;
for (int i=2;i<base;i++) {
    int a=base%i;
    if (a==0) {
        hasFactor = true;
        break;
    }
}
if (!hasFactor){
    System.out.println(base+" is a prime number, so it has no factors");
}