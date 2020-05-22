Scanner sc = new Scanner(System.in);
int N = sc.nextInt();
ArrayList<StringBuffer> al = new ArrayList<StringBuffer>();
Set<String> uniques = new HashSet<>();
while (N-- > 0) {
   uniques.add(sc.next());
}
for (String s : uniques)
    al.add (new StringBuffer(s));