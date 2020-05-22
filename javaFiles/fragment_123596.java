Scanner s = new Scanner(new BufferedReader(new StringReader("cookies; and juice")));
//              | whitespace
//              |  | or 
//              |  | | something followed by punctuation (non-capturing group)
//              |  | | 
s.useDelimiter("\\s|(?=\\p{Punct})");
while (s.hasNext()) {
    System.out.println(s.next());
}