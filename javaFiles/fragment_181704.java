char[] arrayA = new char[] {'a', 'b', 'c', 'd', 'e', 'f'};
char[] arrayB = new char[] {'a', 'd', 'e'};
Character[] objarrayA = ArrayUtils.toObject(arrayA);
Character[] objarrayB = ArrayUtils.toObject(arrayB);
Set<T> setA = new HashSet(Arrays.asList(objarrayA));
Set<T> setB = new HashSet(Arrays.asList(objarrayB));

setA.removeAll(setB);