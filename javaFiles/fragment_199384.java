public interface PlayerProviderable
{
    Player createNewPlayer(Socket socket);
    Player getPlayer(int key); // maybe the key is an index...depending on implementation
}

public class Game implements PlayerProviderable
{
    // fields as usual...
    // constructor as usual

    // add a List for the player here...or a map.
    // Map<Integer, Player> players = new HashMap<Integer, Player>();
    List<Player> players = new ArrayList<Player>(); // if this is the list implementation. consider using a Map instead.

    public synchronized Player createNewPlayer(Socket socket)
    {
         // add the player to a list or to a dictionary.
         // this is the List implementation.
         int id = players.size();
         players.add(new Player(id, socket));

         //players.put(id, new Player(id, socket)); // to a map.
    }

    public synchronized Player getPlayer(int key)
    {
        // retrieve a player from a list or from a dictionary with the given key. the key is the id or the index. You decide.
       // it could be better to use a Map here instead of a list.
       // but this is the a simple list implementation; Will throw an exception or return null (implementation specific) if the key does not exists.

        return players.get(key); // as we did not provide a method to delete a player. Otherwise, you will need to iterate over all of the players and find the one with the id you wanted. 
        // or just use a Map instead of a list.

    }
}