class ChessGame 
class DifficltChessGame extends ChessGame
class MediumChessGame extends ChessGame
class SimpleChessGame extends ChessGame
class ChessGameFactory {
     public static ChessGame getChessGame(String gameType) {
         switch(gameType) { //jdk7
             case "easy":
                 return new SimpleChessGame();
              ....
         }
     }
}