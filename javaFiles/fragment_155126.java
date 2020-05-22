ArrayList<String> product_words = new ArrayList<String>();
product_words.add("one");
product_words.add("two");
product_words.add("three");
product_words.add("four");

for (int i = 0; i < product_words.size(); i++) {
    String s = "";
    for (int j = i; j < product_words.size(); j++)  {
        s += product_words.get(j);
        s += " ";
        System.out.println(s);
    }
}