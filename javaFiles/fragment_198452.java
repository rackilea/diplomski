public class MyData{
    Date date;
    float data[];
}
List<MyData> data = new ArrayList<MyData>();
/// add everything into data

Collections.sort(data, new Comparator<MyData>(){
    @Override
    public int compare(MyData data1, MyData data2) {
        // compare on year
    }
});
// Copy into new List

Collections.sort(data, new Comparator<MyData>(){
    @Override
    public int compare(MyData data1, MyData data2) {
        // compare on month
    }
});
/// keep sorting and copying