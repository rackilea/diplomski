boolean evaluate(Node nfa, String str)
{
    Set<Node> fromStates = new Set();
    fromStates.add(nfa);
    closeEpsilons(fromStates);

    for (char chr in str)
    {
        if (fromStates.size()==0)
            return false;

        //find all the states we can get to from
        //fromStates via chr

        Set<Node> toStates = new Set();
        for (Node fromState in fromStates)
        {
            //OP's code would say .getPathMap(chr) here
            for(Node toState in fromState.getTransitionTargets(chr))
            {
                if (!toStates.contains(toState))
                    toStates.add(toState);
            }
        }
        closeEpsilons(toStates);

        //process the rest of the string with the state set we just found
        fromStates = toStates;
    }

    //string is done.  see if anything accepts
    for(Node state in fromStates)
    {
        if (state.accepts())
        {
            return true;
        }
    }
    return false;
}

//expand a state set with all states is reaches via epsilons
void closeEpsilons(Set<Node> states)
{
    Queue<Node> processQueue = new Queue();
    processQueue.addAll(states);

    while(!processQueue.isEmpty())
    {
        Node fromState = processQueue.removeFirst();

        //OP's code would say "getPathMap("e") here
        for(Node toState in fromState.getEpsilonTargets())
        {
            if (!states.contains(toState))
            {
                //found a new state
                states.add(toState);
                //we'll have to search it for epsilons
                processQueue.add(toState);
            }
        }
    }
}