int i = 0;
while(i < 4){
    if(i % 3 == 0){
        i++;       //Remember to increase i before continue
        continue;
    }
    else
        sum += i;
    i++;
}