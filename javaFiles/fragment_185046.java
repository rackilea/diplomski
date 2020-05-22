int tally = 0;
for ( int i = 0; i < numbers.length; i++ ){
    if (numbers[i] != 0 ){
        sum = sum + numbers[i];
        tally++;
    }
}
int average = sum / tally;