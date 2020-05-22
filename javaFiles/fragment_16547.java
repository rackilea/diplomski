int currentHigh = 0;
int noOfCountries = 10;
int input;

for(int i=0; i<noOfCountries; i++) {
    input = in.nextInt();
    if(input>currentHigh) {
        currentHigh=input;
    }
}