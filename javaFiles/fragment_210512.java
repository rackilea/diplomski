for(int i = 0 ;;)
{
    int byteNo = System.in.read();
    if(byteNo == 10 || byteNo == 13)
        continue;
    char letter = (char)byteNo;
    if(letter == 's' || letter == 'S')
        break;
    System.out.println("Pass # " + ++i);
}