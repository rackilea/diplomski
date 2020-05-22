Document doc = new Document("D:\temp\in.doc");

for(Run run : (Iterable) doc.getChildNodes(NodeType.RUN, true)) {
    System.out.println(run.getText());
    System.out.println(run.getFont().getName());
}