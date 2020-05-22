s= reader.readline()
String tokens[]=  s.split(" ");
int nums[]  = new int[tokens.length];
for(int i=0; i<tokens.lenght; i++) {
    nums[i] = Integer.parseInt(tokens[i]);
}