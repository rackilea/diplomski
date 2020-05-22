string.split("\\s{2,}");

 String string = "I am  Chaitanya Gadam.      Split   this srting.";

    String[] str = string.split("\\s{2,}");

    for(String s: str)
    {
        System.out.println(s+":"+s.length());
    }
    System.out.println(Arrays.toString(string.split("\\s\\s+")));

Output:
I am:4
Chaitanya Gadam.:16
Split:5
this srting.:12
[I am, Chaitanya Gadam., Split, this srting.]