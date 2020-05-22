static int generateRandom(){
    Random rnd = new Random();
    int number = rnd.nextInt(100);
    if(number<30){
        //30% chance to return 1
        return 1;
    }else if(number<30+25){
        //25% chance to return 2
        return 2;
    }else if(number<30+25+10){
        //10% chance to return 6
        return 6;
    }else{
        //45% chance to return 3
        return 3;
    }
}