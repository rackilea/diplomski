byte[] plainTextBytes = "Hello World".getBytes();

int[] ints = new int[plainTextBytes.length];

for(int i = 0; i < ints.length; i++){
    ints[i] = plainTextBytes[i];
}