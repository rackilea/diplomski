...
        //invoke the start symbol, rule parse
        walker.transitions();

        //get the stored transitions and print them out.            
        List<Transitions> transitions = walker.getAllTransitions();
        System.out.println(transitions);
        ...