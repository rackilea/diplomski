int length = (int) (Math.log10(num) + 1);    // finds the number of digits

int output = 0;
int counter = 0;
for (int i=0; i < length; ++i) {
    if ((num % 10) % 2 == 0) {
        output += (num % 10) * Math.pow(10, counter);
        ++counter;
    }
    num = num / 10;
}

System.out.println(output);

2826