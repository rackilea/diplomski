iParser.query_return r = parser.query();
CommonTree t = (CommonTree) r.getTree();

for (int i = 0, count = t.getChildCount(); i < count; ++i) {
    CommonTree child = (CommonTree) t.getChild(i);
    System.out.println("child type: " + child.getType());
    System.out.println("child text: " + child.getText());
    System.out.println("------");
}