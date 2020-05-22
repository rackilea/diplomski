for( Node n : doc.body().childNodes() )
{
    if( n instanceof TextNode )
    {
        str = n.toString().trim();

        if( str.toLowerCase().startsWith("alex") ) // Node 'Alex'
        {
            String t[] = n.toString().split(","); // you have an array with each word as string now

            System.out.println(Arrays.toString(t)); // eg. output
        }
    }
}