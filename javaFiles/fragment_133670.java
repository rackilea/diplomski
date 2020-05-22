@Path("/w")
public class JSONRESTService {

    private static BlockingQueue<Player> queue = new ArrayBlockingQueue<>(999);

    @POST
    @Consumes("application/json")
    @Path("/JSONService")
    public String JSONREST(InputStream incomingData) {    


        Player thisPlayer = ...; // Get player from session or something

        System.out.println (thisPlayer.getName() + " starting...");

        try {

            if (queue.isEmpty()) {
                System.out.println ("waiting for an opponent");
                queue.add(thisPlayer);
                synchronized (thisPlayer) {
                    thisPlayer.wait();
                }
            } else {
                System.out.println ("get next in queue");
                Player opponent = queue.take();
                opponent.setOpponent(thisPlayer);
                thisPlayer.setOpponent(opponent);
                synchronized (opponent) {
                    opponent.notify();
                }
            }

            System.out.println (thisPlayer.getName() + " playing " + thisPlayer.getOpponent().getName());

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    static class Player {

        private String name;
        private Player opponent;

        Player (String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public Player getOpponent() {
            return opponent;
        }

        public void setOpponent(Player opponent) {
            this.opponent = opponent;
        }
    }
}