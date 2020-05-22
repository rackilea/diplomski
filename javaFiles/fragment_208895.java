package day6;

public class Player {
    int playerId;

public Player(int playerId) {
    super();
    this.playerId = playerId;
}

public int getPlayerId() {
    return playerId;
}

public int hashCode(){
    return playerId.hashCode();
}

public boolean equals(Object o){
    if (o instanceOf Player) { 
        return playerId.equals( ((Player)o).getPlayerId());
    }
    return false;
}
}