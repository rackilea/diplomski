String[] strs = { "Documento v1.docx", "Some_things.pdf", "Cosasv12.doc", "Document16.docx", "Nodoc"};
Pattern pat = Pattern.compile("v(\\d+)(?=\\.[^.]+$)");
for (String s: strs) {
    StringBuffer result = new StringBuffer();
    Matcher m = pat.matcher(s);
    while (m.find()) {
            int n = 1 + Integer.parseInt(m.group(1));
        m.appendReplacement(result, "v" + n);
    }
    m.appendTail(result);
    System.out.println(result.toString());
}