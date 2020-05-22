Document doc = Jsoup.connect("http://www.example.com").get();
    int count = 0; // Count Nodes

    for( Node n : doc.body().childNodes() )
    {
        if( n instanceof TextNode )
        {
            if( count == 2 ) // Node 'Alex'
            {
                String t[] = n.toString().split(","); // you have an array with each word as string now

                System.out.println(Arrays.toString(t)); // eg. output
            }
            count++;
        }
    }