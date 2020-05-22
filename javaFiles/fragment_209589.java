boolean count=false;
int y=0;
for (int x : arr) {
    if (x == 507)
        count = true;
    else if (x == 504)
        count = false;
    if (count)
        y++;
}
System.out.println(y);