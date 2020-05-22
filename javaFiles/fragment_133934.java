ArrayList<ArrayList<Integer>> table = new ArrayList<ArrayList<Integer>>();
char[] chars = myString.toCharArray();
ArrayList<Integer> current = null;
for(int i=1; i<chars.length-1; ++i) { // To avoid parsing begining and end of the array
    char c = chars[i];
    if(c == '[')
        table.add(current = new ArrayList<Integer>());
    if(c == ']')
        continue;
    current.add(Character.getNumericValue(c));
}
int[][] result = table.toArray(new int[0][0]); // Maybe this will fail and you'll have to use Integer[][] instead