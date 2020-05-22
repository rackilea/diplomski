String text;
try (StringWriter strOut = new StringWriter()) {
    try (PrintWriter out = new PrintWriter(strOut)) {
        for (Node node : nodes) {
            out.println(node);
        }
    }
    text = strOut.toString();
}

try (BufferedReader in = new BufferedReader(new StringReader(text))) {
    for (String line; (line = in.readLine()) != null; ) {
        // use line here
    }
}