Scanner s = new Scanner(input).useDelimiter(WHATEVER_DELIMITERS_YOU_NEED);
sum = 0;
while(true) {
    sum += s.nextInt();
    if(!s.haNext())
        break;
}