public void roll(int numTimes){
    for (int i = 0; i < numTimes; i++){
        int rand = 1 + (int)(Math.random()*this.getSides());
        System.out.println(rand);
    }
}