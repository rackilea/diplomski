String input = io.readInput();
int[] arr = new int[5];

if(input.length() >= 5){
    String[] c = input.split(" ");
    for(int i = 0; i < c.length(); i++){
        arr[i] = Integer.parseInt(c[i]);
    }
}