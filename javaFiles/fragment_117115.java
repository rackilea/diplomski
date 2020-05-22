Scanner sc=new Scanner(System.in);
System.out.println("What will your string be?");
String word=sc.next();
for(int i=0;i<word.length();i++) {
    System.out.print(word.substring(0,i+1));
    for(int j = i+1; j < word.length(); j++) {
        System.out.print(word.charAt(i));
    }
    System.out.println();
}