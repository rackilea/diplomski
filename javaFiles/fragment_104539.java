class State implements List{

static int depth;

String stateName;

//LINKS TO OTHER STATES
Map<State, ArrayList<String>> nextState ; // to link with multiple states
Map<State, ArrayList<String>> preState;             // previous state

public State()
{
    stateName = "";
    nextState = new HashMap<>();
    preState = new HashMap<>();
}
public State(String StName)
{        
    stateName = StName;
    nextState = new HashMap<>();
    preState = new HashMap<>();
}

@Override 
public String toString()
{
    String temp = " "+this.stateName;
    for(State key : this.nextState.keySet())
    {
        temp = (temp + "  ");
        for(String lbl : this.nextState.get(key))
        {
            temp = (temp + lbl);
        }
            temp = temp + "  "+key.stateName+ "\n";       
    } 
    return temp;

}
@Override
public int hashCode() {
    return 1;
}

@Override
public boolean equals(Object obj) {

    if (obj instanceof State) 
    {
        //id comparison
        State st = (State)obj;

        if(!(this.stateName == null) && (!(st.stateName == null)))
            return (this.stateName.equals(st.stateName));
    }
    return false;
}