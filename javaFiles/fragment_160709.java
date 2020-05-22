int n = 27;
int m = n;
int r = m % 16;
String sum = "";

while (m!=0) {
    r = m % 16;
    m = m / 16;
    switch (r) {
    case 10:
        sum = "A" + sum;
        break;

    case 11:
        sum = "B" + sum;
        break;

    case 12:
        sum = "C" + sum;
        break;

    case 13:
        sum = "D" + sum;
        break;

    case 14:
        sum = "E" + sum;
        break;

    case 15:
        sum = "F" + sum;
        break;

    default:
        sum = r + sum;
    }
}
System.out.print(sum);