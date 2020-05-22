public static int hashCode(int a[]) {
  if (a == null)
    return 0;

  int result = 1;
  for (int element : a)
    result = 31 * result + element;
  return result;
}