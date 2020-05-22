public Tournament()
{
    name = new SimpleStringProperty("name");
    rounds = new SimpleIntegerProperty(0);
    eslBreak = new SimpleBooleanProperty(false);
    // etc.
}

public Tournament(String nameIn, int roundsIn, int openBreakTeamsIn, int eslBreakTeamsIn, int noviceBreakTeamsIn, int proAmBreakTeamsIn)
{
    name = new SimpleStringProperty(nameIn);
    rounds = new SimpleIntegerProperty(roundsIn);
    eslBreak = new SimpleBooleanProperty(openBreakTeamsIn);
     // etc.
}