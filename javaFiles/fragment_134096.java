private Integer[] elements;
private int size=0;
private int capacity;

public SortedList(int cap) {

    elements = new Integer[cap];

    if (cap > 0)
    {
        capacity = cap;
    }
    else
        capacity = 10;

}

public boolean isEmpty()
{
    return size == 0;
}

public boolean isFull()
{
    return size == capacity;
}

public int size()
{
    return size;
}

public void doubleCapacity()
{
    capacity = capacity * 2;
}

public void add(Integer el) throws Exception{
    elements[size] = el;
    size++;
    if(size>capacity){
        throw new Exception("Size Exceeded");
    }
}

public String toString()
{
    sort();
    String s = "";
    s = s + "<SortedList[";
    for(int i = 0; i < this.size(); i++)
    {
        s = s + elements[i];
        if(i < this.size()-1)
            s = s + ",";
    }
    s = s + "]>";
    return s;
}

public void sort(){
    for (int i=0; i <size()-1; i++) {
        if (elements[i] > elements[i+1]) {
            // exchange elements
            int temp = elements[i];
            elements[i] = elements[i+1];
            elements[i+1] = temp;
        }
    }
}

public static void main(String[] args)
{
    try {
        SortedList sl = new SortedList(5);
        sl.add(3);
        //sl.add(2);
        sl.add(6);
        sl.add(5);