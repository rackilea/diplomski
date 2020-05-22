int first = 3:
int second = 2;
double result = first / second;  // the result is 1 because first and second are integers

first = 3;
second = 2;
double result1 = (double)first / second;  // result is: 1.5

double result2 = first / (double)second;  // result is: 1.5

double result3 = (double)(first / second);  // result is: 1