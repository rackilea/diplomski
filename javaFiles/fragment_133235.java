public abstract class AClonable implements Cloneable{

private String val;

public AClonable(){

}

public AClonable(String s){
    val=s;
}

public String toString(){
    return val;
}

@Override
public AClonable clone(){
    try {
        System.out.println(getClass().getCanonicalName());
        AClonable b= getClass().getDeclaredConstructor(String.class).newInstance(val);

        return b;
    } catch (InstantiationException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    } catch (IllegalAccessException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    } catch (IllegalArgumentException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    } catch (SecurityException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    } catch (InvocationTargetException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    } catch (NoSuchMethodException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
    return null;
}