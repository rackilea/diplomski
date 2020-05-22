//Store mappings from array name (String) to int arrays (int[])
Map<String, int[]> namedArrays = new HashMap<String, int[]>();
for (int i = 0; i < 3; i++)
{
  //This is going to be the name of your new array
  String arrayName = String.valueOf(i); 
  //Map an new int[] to this name
  namedArrays.put(arrayName, new int[3]);
}

//If you need to access array called "2" do
int[] array2 = namedArrays.get("2")