private int[] myArray = {1,2,3,4,5};
private ArrayList<Integer> myArrayList = new ArrayList<Integer>();

public int[] getMyArray()
{
    return Arrays.copyOf(myArray, myArray.length);
}

public ArrayList<Integer> getMyArrayList()
{
    return new ArrayList<>(myArrayList);
}

public void setMyArray(int[] newArray)
{
    this.myArray =  Arrays.copyOf(newArray, newArray.length);
}

public void setMyArrayList(ArrayList<Integer> newArrayList)
{
    this.myArrayList = new ArrayList<>(newArrayList);
}