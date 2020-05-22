public class CustomFilter<T extends FileFilter>
{

  /*  Where we store our filter  */
  private T filter = null;

  /*  The method to return it  */
  public T getFilter () {
    return filter;
  }

  /*  The constructor to define the filter  */
  public CustomFilter (T filt) {
    this.filter = Objects.requireNonNull(filt, "filt");
  }
}