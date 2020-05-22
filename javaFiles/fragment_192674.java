class Ideone
{
    public static void main (String[] args) throws java.lang.Exception
    {
        List<Integer> list = new ArrayList<Integer>();
        ArrayList<Integer> inRange = Helper.inRange(list, 0,1);
    }
}

class Helper {
    public static <T> List<T> inRange(List<T> list, int index, int range) {
        List<T> res = new ArrayList<T>();
        return res;
    }
}