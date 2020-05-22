Comparator<ArrayList<String>> cmp = new Comparator<ArrayList<String>>()
{
    public int compare(ArrayList<String> a1, ArrayList<String> a2)
    {
        // TODO check for null value
        return new Integer(a1.get(6)).compareTo(new Integer(a2.get(6));
    }
};

Collections.sort(yourList, cmp);