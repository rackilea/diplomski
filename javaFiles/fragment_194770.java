public class MyObject implements Cloneable {

    @Override
    public Object clone() {     
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {            
            return null;
        }
    }
}