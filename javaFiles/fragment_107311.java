boolean[] values = new boolean[100];

int index = Random.nextInt(100);
while(!values[index]){
    System.out.println(index+1);
    values[index] = true;
    index = Random.nextInt(100);
}