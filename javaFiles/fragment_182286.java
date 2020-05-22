for(int i = 1;i < list.size();i++){
    if(temp == list.get(i)){ counter++; }
    else{
        System.out.println(temp+":"+counter);
        number_appearance[j][0] = temp;
        number_appearance[j][1] = counter;
        counter = 1;
        temp = list.get(i);
        j++;
    }
}
number_appearance[j][0] = temp; // added
number_appearance[j][1] = counter; // added