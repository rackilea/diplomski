try{
        ExecutionEngine engine = new ExecutionEngine(graphDb);

        ExecutionResult result = engine.execute("MATCH (sender:person)-[:emails]-(receiver) RETURN sender,  count(receiver)as count, collect(receiver.person) as receivers ORDER BY count DESC ");
        //ExecutionResult result = engine.execute("MATCH (sender:person)-[:emails]->(receiver)  WITH sender, collect(receiver.person) as receivers, RETURN {sender: sender.person,  receivers: receivers) ORDER BY size(receivers) DESC");
        //System.out.println(result.dumpToString());
        LinkedList list_prop = new LinkedList();

        for (Map<String,Object> row : result) {
            Node x = (Node)row.get("sender");
            Object y = row.get("receivers");
            System.out.println(y);  

            for (String prop_x : x.getPropertyKeys()) {
                System.out.println(prop_x +": "+x.getProperty(prop_x));

            }   

        }
        tx1.success();
    }
    finally {
        tx1.close();

    }