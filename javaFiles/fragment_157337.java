class TicTac { 
    public TicTac(int size) { }
    public TicTac(TicTac otherTicTac) { }
    ...
 }
 //elsewhere: 
 TicTac first = new TicTac(5);  //or just TicTac first = new TicTac() 
 TicTac second = new TicTac(first);