Map<String, ArrayList<String>> sections = new HashMap<>();
Map<String, String> sections2 = new HashMap<>();
String s = "", lastKey="";
try (BufferedReader br = new BufferedReader(new FileReader("input.txt"))) {
    while ((s = br.readLine()) != null) {
        String k = s.substring(0, 10).trim();
        String v = s.substring(10, s.length() - 50).trim();
        if (k.equals(""))
            k = lastKey;

        ArrayList<String> authors = null;
        if(sections.containsKey(k))
        {
            authors = sections.get(k);
        }
        else
        {
            authors = new ArrayList<String>();
            sections.put(k, authors);
        }
        authors.add(v);
        lastKey = k;
    }
} catch (IOException e) {
}

// to get the number of authors
int numOfAuthors = sections.get("AUTHOR").size();

// convert the list to a string to load it in a GUI
String authors = "";
for (String a : sections.get("AUTHOR"))
{
    authors += a;
}