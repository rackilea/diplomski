public class Randoms implements Iterator<Double> {

  private int counter = 10;

  @Override 
  public boolean hasNext() { 
     return counter > 0; 
  }

  @Override 
  public boolean next() { 
     count--;
     return Math.random();        
  }      

  @Override 
  public boolean remove() { 
     throw new UnsupportedOperationException("delete not supported"); 
  }
}