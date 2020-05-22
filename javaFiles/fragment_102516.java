package collectionuse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Entity{
    String name;

    public void setName(String name){
        this.name = name;
    }
}

class Chunk{
    Entity[] entity;
    String name;

    Chunk(){

    }

    Chunk(String name){
        this.name = name;
        entity = new Entity[2];
        Entity e1 = new Player();
        Entity e2 = new Player();
        e1.setName(name);
        e2.setName("Dummy");
        entity[0] = e1;
        entity[1] = e2;
    }

    public Entity[] getEntities() {
        return entity;
    }
}

class Player extends Entity{

}

public class MapsT {

    public void checkMap(){
        Map<Chunk, List<Player>> chunkListMap = new HashMap<>();
        List<Chunk> affectedChunks = new ArrayList<Chunk>();
        Chunk ch = new Chunk("Z");
        affectedChunks.add(0, ch);
        affectedChunks.add(1, ch);

        affectedChunks.add(2, new Chunk("A"));
        affectedChunks.add(3, new Chunk("B"));
        affectedChunks.add(4, new Chunk("C"));
        affectedChunks.add(5, new Chunk("D"));

        for (Chunk c : affectedChunks) {
          List<Player> currentPlayers = playersInChunk(c);
          if (!chunkListMap.containsKey(c)) {
            chunkListMap.put(c, currentPlayers);
            continue;
        }

        List<Player> previousPlayers = chunkListMap.get(c);
        List<Player> enteringPlayers = new ArrayList<>(currentPlayers);
        enteringPlayers.removeAll(previousPlayers);
        //for (Player player : enteringPlayers) applyEffects(player);

        List<Player> leavingPlayers = new ArrayList<>(previousPlayers);
        leavingPlayers.removeAll(currentPlayers);
        //for (Player player : leavingPlayers) unapplyEffects(player);
        }

    }

    private List<Player> playersInChunk(Chunk c) {
        List<Player> retVal = new ArrayList<>();
        for (Entity e : c.getEntities()) {
            if (e instanceof Player) retVal.add((Player) e);
        }
        return retVal;
    }

    public static void main(String[] args) {
        MapsT mapt = new MapsT();
        mapt.checkMap();
    }

}