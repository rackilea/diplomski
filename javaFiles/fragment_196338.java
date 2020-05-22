Random rnd = new Random()

int rand1 = rnd.nextInt(copyList.size() - 1); 
int rand2 = rnd.nextInt(copyList.size() - 2);

if(rand2 >= rand1) rand2++;