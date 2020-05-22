class UltimateComputerPlayer {
    private SquareStatus mysymbol;

    public UltimateComputerPlayer(int nc) {
        super();


        if (nc == 1)
            mysymbol = NCGridV3.SquareStatus.CROSS;
        if (nc == 2)
            mysymbol = NCGridV3.SquareStatus.NOUGHT;
    }

    // [...]
}