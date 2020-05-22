BufferedReader reader = new BufferedReader(new StringReader(string));
List<String> lines = new ArrayList<String>();

for (String line = null; (line = reader.readLine()) != null;) {
    lines.add(line);
}

// ...