randnum = 1 + gen.nextInt(dice);
System.out.println(randnum + " ");
System.out.println();
for(int counter=1; counter <= print; counter++){
    if (randnum == numbers[counter - 1]){
        lose = false;
        break;
    } else {
        lose = true;
    }
}