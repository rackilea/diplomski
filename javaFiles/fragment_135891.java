int[] level ={1,2,3,4,5,6,7,8,9,10};
int[] charHpArray = {5,10,15,20,25,30,35,40,45,50};

for (int i : level) {
    int j = charHpArray [i];
    System.out.println("Level " + i + ", charHpArray element: " + j);
}