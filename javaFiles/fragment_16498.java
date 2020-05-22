rand = new Random(); 
randomNum1 = rand.nextInt(max - min + 1) + min;
randomNum2 = rand.nextInt(max - min + 1) + min;

while (randomNum2==randomNum1){
    randomNum2 = rand.nextInt(max - min + 1) + min;
}