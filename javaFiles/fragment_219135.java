public static Map<String, List<Shop>> mySortedMap(final Map<String, List<Shop>> orig)
{
    final Comparator<String> c = new Comparator<String>()
    {
        @Override
        public int compare(final String o1, final String o2)
        {
            // Compare the size of the lists. If they are the same, compare
            // the keys themsevles.
            final int sizeCompare = orig.get(o1).size() - orig.get(o2).size();
            return sizeCompare != 0 ? sizeCompare : o1.compareTo(o2);
        }
    }

    final Map<String, List<Shop>> ret = new TreeMap<String, List<Shop>>(c);
    ret.putAll(orig);
    return ret;
}