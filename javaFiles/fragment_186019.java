int answer = 0;
int power = 1;

for (int i = 0; i < inputString.length(); i++) {
    int charValue = inputString.charAt(i) - 'a';
    answer += ( charValue * power );
    answer %= mod;
    power *= 26;
    power %= mod;
}