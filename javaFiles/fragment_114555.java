public class MyBooleanConverter extends BooleanConverter{

    @Override
    public String toString(Object obj) {
        if(((Boolean)obj).equals(false)){
            return null;
        }
        return super.toString(obj);
    }   

}