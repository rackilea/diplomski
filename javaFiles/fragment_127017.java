public class ArrayABC<E> {

  private int currentSize, maxCapacity;
  private E[] list;

  public ArrayABC(){
          currentSize = 0;
          maxCapacity = 20;
          list = (E[]) new Object[maxCapacity];
  }

  public E removeLast(){
          if(currentSize == 0)
              return null;
          list[currentSize] = null;
          currentSize--;
          return list[currentSize];
  }
}