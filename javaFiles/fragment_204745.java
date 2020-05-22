public int getRandomNumber(){
Random r = new Random();
int nr = r.nextInt(13);
return nr;
}
...
 JLabel label = new JLabel(getRandomNumber(), JLabel.CENTER);