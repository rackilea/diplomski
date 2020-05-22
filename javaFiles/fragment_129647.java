try 
        {
            /* CREATE THE PARSER  */
            XMLParser parser      = new XMLParser();
            /* CREATE THE FILTER (THIS IS A REGEX (X)PATH FILTER) */
            XMLRegexFilter filter = new XMLRegexFilter("statements/statement");
            /* CREATE THE HANDLER WHICH WILL BE CALLED WHEN A NODE IS FOUND */
            XMLHandler handler    = new XMLHandler()
            {
                public void nodeFound(StringBuilder node, XMLStackFilter withFilter)
                {
                    // DO SOMETHING WITH THE FOUND XML NODE
                    System.out.println("Node found");
                    System.out.println(node.toString());
                }
            };
            /* ATTACH THE FILTER WITH THE HANDLER */
            parser.addFilterWithHandler(filter, handler);
            /* SET THE FILE TO PARSE */
            parser.setFilePath("/path/to/bigfile.xml");
            /* RUN THE PARSER */
            parser.parse();
        } 
        catch (Exception ex) 
        {
            ex.printStackTrace();
        }