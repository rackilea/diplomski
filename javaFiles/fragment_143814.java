class Game {
     GameState state = GameState.getInitialState( this );

     void run() {
         while( state.alive ) {
              do X Y Z
              state.updateState();
          }
     }
  }


class GameState {
    Game context;
    static GameState getInitialState( Game g ) {
        return new StartGameState(g);
    }
    void updateState();
}

class StartGameState {
     void updateState() {
         if( this.context.someCondition() ) {
             this.context.state = new MidGameState();
         }
     }
 }


class MidGameState {
     void updateState() {
         if( this.context.someOtherCondition() ) {
             this.context.state = new EndGameState();
         }
     }
 }

class EndGameState {
     void updateState() {
        Game over... 
     }
 }