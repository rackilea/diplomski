String [] arr = {"A", "B", "C", "D"};

Random random = new Random();
int n = 0;
int e = 0;

//A random integer that is greater than 1 but not larger than arr.length
n = random.nextInt(arr.length - 2 + 1) + 2;

//loops n times selecting a random element from arr each time it does
for(int i = 0; i < n; n++){
   e = random.nextInt(arr.length);
   System.out.println("Random String selected: " + arr[e]);
}