public class Data{
    public String test;
    public Integer i;

}

ArrayList<Data> mArrayList = new ArrayList<Data>();
.
.
.


Collections.sort(mArrayList, new Comparator<Data>() {
            public int compare(Data d1, Data d2) { 
                return d1.i.compareTo(d2.i);
            });