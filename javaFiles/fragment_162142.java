import java.util.List;
import java.util.ListIterator;

class Helper {
    public static float[] toFloatArray(List l) {
        float retValue[] = new float[l.size()];
        ListIterator iterator = l.listIterator();
        for (int idx = 0; idx < retValue.length; ++idx ){
            // List had better contain float values,
            // or else the following line will ClassCastException.
            retValue[idx] = (float) iterator.next();
        }
        return retValue;
    }
}