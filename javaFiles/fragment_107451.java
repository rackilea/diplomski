ArrayList<Integer> list = new ArrayList<Integer>();
for(int i=0;i<52;i++){
    list.add(i+1);
}
int c = 52;
Random random = new Random();
while(c>0){
    int r = random.nextInt(c--);
    int card = list.get(r);
    list.remove(r);
}
resetList();