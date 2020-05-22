public class Object {
    // Other methods

    public String toString(){
        // This is the method super.toString() will use once called in SuperChk
        return getClass().getName() + "@" + Integer.toHexString(hashCode());
    }

}