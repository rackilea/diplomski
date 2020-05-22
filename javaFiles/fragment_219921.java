Scanner sc = new Scanner(System.in);
int N = sc.nextInt();
ArrayList<StringBuffer> al = new ArrayList<StringBuffer>();
Set<String> uniques = new HashSet<>();
while (N-- > 0) {
   String str = sc.next();
   if (!uniques.add(str))
       System.out.println("Duplicate value " + str);
}
for (String s : uniques)
    al.add (new StringBuffer(s));