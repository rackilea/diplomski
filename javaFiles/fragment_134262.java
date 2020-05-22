int counter = 0, num = 1, total = 0;
while(num != 0){
    num = scan.nextInt();
    if(num == 0)
        break;
    counter++;
    total += num;
}
double average = (double)total/counter;