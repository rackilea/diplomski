int number = 5;
int input = 543655;
int sum = 0;

while (input > 0) {
    if (input % 10 == number) {
        sum += number;
    }

    input /= 10;
}