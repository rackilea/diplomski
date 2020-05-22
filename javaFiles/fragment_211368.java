public interface Level {
     // do updates for level start on game
     void updateGameLevelStart(Game game);

     // cleanup code e.g. unregistering event handlers...
     void updateGameLevelEnd(Game game);
}