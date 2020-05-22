int answer = 0;
int power = 1;

for (int i = inputString.length() - 1; i >=0; i--) {

    if(inputString.charAt( i ) < 58)  {
        int charValue  = inputString.charAt( i ) - 48;
        answer += charValue;
    }       
    else {  
        int charValue  = inputString.charAt( i ) - 96;
        answer += ( charValue * power );
    }

    answer %= mod;
    power *= 26;
    power %= mod;
}