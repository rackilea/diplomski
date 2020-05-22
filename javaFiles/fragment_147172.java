Class<?> compType = prop1.getClass().getComponentType();
if (compType == int.class)
    Arrays.sort((int[])prop1);
else if (compType == float.class)
    Arrays.sort((float[])prop1);
// ... 5 more ...
else if (Comparable.class.isAssignableFrom(compType))
    Arrays.sort((Comparable[])prop1);
else
    throw new UnsupportedOperationException("Cannot sort array of " + compType.getName());