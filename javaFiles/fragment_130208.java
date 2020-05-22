int b = 1;
int c = 2, d;
long sum = 0;
while(c < 4000000) {
    sum += c;
    d = b+(c<<0x01);
    c = d+b+c;
    b = d;
}
System.out.println(sum);