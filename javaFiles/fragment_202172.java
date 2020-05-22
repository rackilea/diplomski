double count1 = Double.parseDouble(message);
double countStart = 3.5;

int resultCount = (int)(count1 - countStart) + 1;
double results = new double[resultCount];

for(double i = 0; i < resultCount; ++i) {
    double result = countStart + i;
    if (result > count1) {
        break;
    } else {
        results[i] = result;
    }
}