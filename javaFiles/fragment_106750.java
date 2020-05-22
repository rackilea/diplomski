static void codieren(String s){
    int Zähler = 0;
    char[] a = s.toUpperCase().toCharArray();
    for (int i = 0; i<s.length()-2; i++){
        if (a[i] == a[i+1] && a[i] ==a[i+2]){
            Zähler = 3;
            while ((i+Zähler) < s.length() && a[i] == a[i+Zähler]) {
                Zähler++;
            }
            i = i + Zähler - 1;
        }
        System.out.print(a[i]);
        if (Zähler != 0) {
            System.out.print(String.valueOf(Zähler));
        }
    }
}