for(int counter = 1; counter <= print; counter++){
    randnum = 1 + gen.nextInt(dice);
    System.out.println(randnum + " ");
    System.out.println();

    for(int i = 1; i <= print; i++){
        if (lose == false){
            break;
        }
        if (randnum == numbers[i - 1]){
            lose = false;
            break;
        } else {
            lose = true;
        }
    }
}