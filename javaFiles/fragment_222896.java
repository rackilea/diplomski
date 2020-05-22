int x= Integer.parseInt(a);
int meinArray[];
meinArray = new int[x];
Random rand = new Random();

for (int i = 0; i < x; i++){
    meinArray[i] = rand.nextInt();
}