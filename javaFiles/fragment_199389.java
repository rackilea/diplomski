index = 6;
ch = ppsNumber.charAt(index);
while(index < ppsNumber.length() && ch >= '0' && ch <= '9'){
    index--;
    if(index < ppsNumber.length())
        ch = ppsNumber.charAt(index);
}
if(index == ppsNumber.length()-1)
    System.out.println("You entered a valid PPS number.");