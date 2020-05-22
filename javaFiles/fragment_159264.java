Random rand = new Random();
int min = 0;
int max = list.size() - 1;
int randomNum = rand.nextInt((max - min) + 1) + min;

String question = list.get(randomNum);
list.remove(randomNum);