// create your list outside the loop like this:
List<Node> list = new ArrayList<Node>();

for(File workfile : folder.listFiles())
{
    if(workfile.isFile())
    {
        Document doc = builder.parse(workfile);

        // call the recursive method here:
        parseTags(doc.getDocumentElement(), list);
    }
}