public static void main(String[] args)
{
    String s = "12222533343332";
    List<Integer> in = new ArrayList<>();
    for(String ns : s.split("")) in.add(Integer.parseInt(ns));
    System.out.println(extractRepeats(in));     
}