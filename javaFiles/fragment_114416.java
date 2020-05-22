public static void main (String[] args) throws java.lang.Exception
{
  final int[] l = new int[]{9, 17, 39, 35, 20, 18, 34, 11, 2, 45, 46, 15, 33, 47, 10, 27};
  final List<Integer> n = Arrays.asList(32, 39, 86, 81, 64, 53, 76, 40, 46, 63, 88, 56, 52, 50, 22, 38);
  List<Integer> listCopy = new ArrayList(n);
  Collections.sort(n,  new Comparator<Integer>() {
    public int compare(Integer left, Integer right) {
        return l[listCopy.indexOf(left)]-l[listCopy.indexOf(right)]; \\notice the listCopy.indexOf()
    }
  });
  System.out.println(n);
}