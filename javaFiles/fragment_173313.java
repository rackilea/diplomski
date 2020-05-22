String s;
int t;
ArrayList<String> al = new ArrayList<>();
Scanner sc = new Scanner(new InputStreamReader(System.in));
t = sc.nextInt();
try {
    while (sc.hasNext()) {
            s = sc.next();
            al.add(s);
    }
} catch (Exception e) {
    e.printStackTrace();
}