public class G {

public static <T> T[] listToArray(ArrayList<T> inputList)
{
    @SuppressWarnings("unchecked")
    Class<T> type = (Class<T>)inputList.get(0).getClass();
    @SuppressWarnings("unchecked")
    T[] resultArray = (T[]) Array.newInstance(type, inputList.size());

    for(int i=0; i < inputList.size(); i++)
    {
        resultArray[i] = (T)inputList.get(i);
    }
    return resultArray;
}

public static void main( String[] args ) {
    ArrayList<Double> lst = new ArrayList( Arrays.asList( new Double[]{1.11, 2.22, 3.33} ) );
    Double[] d = listToArray( lst );
    System.out.println(d[0]);
}