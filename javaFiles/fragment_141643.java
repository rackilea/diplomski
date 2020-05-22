List<BigInteger> newValues = new ArrayList<BigInteger>();

String[] newValuesArray = new String[unsorted.length];
for (int i = 0; i < unsorted.length; i++) {
    newValues.add(new BigInteger((unsorted[i])));
}