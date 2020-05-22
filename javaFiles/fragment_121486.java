@Test
public void testIt(){
    String a = "abcdesdikdikcdkofkvcdqwppqcddddcdlpqa";
    String b = "cd";

    int i = 0;
    while (a.contains(b)){
        a = a.replaceFirst(b,"");
        i++;
    }
    System.out.println("found:"+i);

}