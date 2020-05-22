Resources res = getResources();
int[] ints = res.getIntArray(R.array.integer_array);
String[] strings = res.getStringArray(R.array.string_array);

//add them to your object array
ArrayList<YourObject> list = new ArrayList();

int i = 0;
while(i < ints.length){
    //make sure the two lists are the same size
    list.add(new YourObject(ints[i], strings[i]));
    i++;
}