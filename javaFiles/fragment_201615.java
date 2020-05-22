abstract class AbstractFactory {
 public abstract BoardType createBoard(BoardType boardType);
}  

class BoardFactory extends AbstractFactory {
 // Implementation
}

class AwesomeBoardFactory extends AbstractFactory {
 // Implementation
}

public static void main(String[] args){
 AbstractFactory factory = new AwesomeFactory();
 Board b1 = factory.CreateBoard(BoardType.MOTHER_BOARD);
}