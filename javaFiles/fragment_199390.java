index = 6;
ch = ppsNumber.charAt(index);
while(index < 0 && ch >= '0' && ch <= '9'){
    index--;
    ch = ppsNumber.charAt(index);
}