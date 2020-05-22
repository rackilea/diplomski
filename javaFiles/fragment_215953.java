import java.util.Comparator;
import java.util.Date;


public class StampDateComparator implements Comparator<Object> {

@Override
public int compare(Object o1, Object o2) {

    try {
        Date d1 = (Date) o1.getClass().getDeclaredField("stampDate").get(o1);
        Date d2 = (Date) o2.getClass().getDeclaredField("stampDate").get(o2);
        return compare(d1, d2);
    } catch (SecurityException e) {
        throw new RuntimeException(e);
    } catch (NoSuchFieldException e) {
        throw new RuntimeException("Missing variable stampDate");
    }catch (ClassCastException e) {
        throw new RuntimeException("stampDate is not a Date");
    } catch (IllegalArgumentException e) {
        //shoud not happen
        throw new RuntimeException(e);
    } catch (IllegalAccessException e) {
        throw new RuntimeException(e);
    }
}

}