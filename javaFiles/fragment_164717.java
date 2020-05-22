Player[] players;

    //Players added to array here

    public boolean someMethod() {
        for (Player p : players)
            if (!p.cantMove())
                return false;
        return true;
    }