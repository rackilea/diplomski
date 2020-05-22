StringWriter out = new StringWriter();
for (Node node : nodes) {
    out.write(node + "\n");
}

BufferedReader in = new BufferedReader(new StringReader(out.toString()));
for (String line; (line = in.readLine()) != null; ) {
    // use line here
}