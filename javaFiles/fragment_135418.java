final char[] first ={'a','b'};
final char[] second ={'a','b'};

Assert.assertFalse(first.equals(second));
Assert.assertFalse(first.hashCode() == second.hashCode());

final Wrapper<char[]> firstWrapped = CHAR_ARRAY_EQUIV.wrap(first);
final Wrapper<char[]> secondWrapped = CHAR_ARRAY_EQUIV.wrap(second);

Assert.assertTrue(firstWrapped.equals(secondWrapped));
Assert.assertTrue(firstWrapped.hashCode() == secondWrapped.hashCode());