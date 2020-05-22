while (input > 0){
    rem = input % 10;
    sum = sum + rem;       //same as : sum += rem
    input = input / 10;    //same as : input /= 10;
}
System.out.println(sum);