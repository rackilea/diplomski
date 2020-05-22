StringBuilder buf = new StringBuilder();
for (Node node : nodes) {
    buf.append(node).append('\n');
}

BufferedReader in = new BufferedReader(new StringReader(buf.toString()));
for (String line; (line = in.readLine()) != null; ) {
    // use line here
}