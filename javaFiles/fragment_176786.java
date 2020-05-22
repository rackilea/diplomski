public class myTestClass implements Serializable{

List<Double> list = new ArrayList<Double>(10);

public void myTestClass(){

    for (int i = 0; i < 10; i++)
        list.add( (double) i);
}