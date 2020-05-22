public class Owner {
  //structure that store grid, all related squares and all related workers
  private Grid grid;
  private Map<Square, Collection<Worker>> squareWorkerMap;      

  public Grid getGrid() {
    return grid;
  }

  public Collection<Square> getAllSquares() {
    return squareWorkerMap.values();
  } 

  public Collection<Worker> getWorkers(Square sq) {
    squareWorkerMap.get(sq);
  } 

  public ??? getSquare(Worker worker) {
    //implementation depends on if worker can belong to many squares
  }
}

public class Grid {
  private Owner mainTopOwner;

  public Collection<Square> getSquares() {
    return mainTopOwner.getAllSquares();
  }
  public Collection<Worker> getWorkers(Square sq) {
    return mainTopOwner.getWorkers(sq);
  }
}

public class Square {
  private Owner mainTopOwner;

  public Collection<Workers> getWorkers() {
    return mainTopOwner.getWorkers(this);  
  }
  public Grid getGrid() {
     return mainTopOwner.getGrid;
  } 
}

public class Worker {
  private Owner mainTopOwner;

  public Square getSquare() {
    return mainTopOwner.getSquare(this)
  }
  public Grid getGrid() {
    return mainTopOwner.getGrid;
  }
}