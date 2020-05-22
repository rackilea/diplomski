State find(State state)
{
    LinkedList<State> list = new LinkedList<>();
    list.push(null);
    State temp = null;
    State ptr = startState;
    if(ptr.stateName.equals(state.stateName))
        temp  = ptr;
    while(ptr != null && temp != ptr)
    {
        for(State nxtState :ptr.nextState.keySet())
        {
            if(state.stateName == null ? nxtState.stateName == null :     state.stateName.equals(nxtState.stateName))
            {
                return nxtState;
                //break;
            }
            else
            {
                list.push(nxtState);
            }
        }
        ptr = list.pop();
    }
    return temp;
}
boolean insertState(State stateA,  String label, State stateB)
{

    ArrayList<String> lbls = new ArrayList<>();
    lbls.add(label);
    stateA = find(stateA);
    if(stateA != null)
    {
        stateB.nextState = new HashMap<>();
        stateB.preState.put(stateA,lbls);
        stateA.nextState.put(stateB, lbls);
        currentState = stateB;
        State.depth++ ;
        return true; 
    }
    else
    {
        System.err.println("State does not exist : somthing wrong with state input or NFA creation");
        return false;
    }

}

void displayNfa()
{
    LinkedList<State> stateForIteration = new LinkedList<>();
    State ptr = startState;
    if(ptr == null)
    {
        System.out.println("The NFA is empty");
    }
    else
    {
        System.out.print(ptr);

        while(ptr!= null)
        {
            if(!ptr.nextState.isEmpty())
            {
                for(State key : ptr.nextState.keySet())
                {
                  System.out.print(key+ "  ");
                   stateForIteration.push(key);
                   }
                ptr = stateForIteration.pop();
            }
            else
            {
                ptr = null;
            }
        }
    }
    System.out.println();
}

/**
 *
 * @param args the command line arguments
 */
void insertRule(String[] rule)
{
for(int i = 0; i < rule.length - 2; i=i+2)
{
    this.insertState(new State(rule[i]), rule[i+1], new State(rule[i+2]));
}
}
public static void main(String[] args) 
{

    State strtState = new State("A");
    NFA ll = new NFA(strtState);
    String[][] data = {
        {"A","0","B","1","C","1","D","1","C0"},
        {"A","0","B","1","C","1","D","1","C0"},
        {"A","0","C","1","D","1","C0"},
        {"A","0","D","1","C0"}
        //{"A","0","B","1","C","1","D","1","C0"},
      };

    ll.insertRule(data[0]);
    ll.insertRule(data[1]);
    ll.insertRule(data[2]);
    ll.insertRule(data[3]);

    ll.displayNfa();
}