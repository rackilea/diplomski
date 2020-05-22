@Entity
class MyEntity {
    @Lob
    DoubleArray data;
}  



public class DoubleArray implements Serializable {

    private double[] data;

    //constructor, getter and setter

}