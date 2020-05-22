public static HashMap<Integer, List<MySpecialClass>> copy(
    HashMap<Integer, List<MySpecialClass>> original)
{
    HashMap<Integer, List<MySpecialClass>> copy = new HashMap<Integer, List<MySpecialClass>>();
    for (Map.Entry<Integer, List<MySpecialClass>> entry : original.entrySet())
    {
        copy.put(entry.getKey(),
           // Or whatever List implementation you'd like here.
           new ArrayList<MySpecialClass>(entry.getValue()));
    }
    return copy;
}