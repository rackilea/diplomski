static class TurnController
{
    // whose turn it is; start with X
    private Player whoseTurn = Player.X;

    // the instance variable
    private static final TurnController instance = new TurnController();


    private TurnController()
    {
    }

    public static Player currentTurn()
    {
        return instance.whoseTurn;
    }

    public static Player nextTurn()
    {
        switch (instance.whoseTurn) {
        case X:
            instance.whoseTurn = Player.O;
            break;

        case O:
            instance.whoseTurn = Player.X;
            break;
        }

        return instance.whoseTurn;
    }

    public static String getMarkerAndAdvance()
    {
        String marker = currentTurn().toString();

        nextTurn();

        return marker;
    }

    enum Player
    {
        X,
        O,
        ;
    }
}