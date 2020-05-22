/***
 * INCOMPLETE: Doesn't have imports or anything like that.
 ***/

public interface Quartz extends Library
{
  public static Quartz instance = (Quartz)Native.loadLibrary("Quartz", Quartz.class);
}

public interface IKPictureTaker extends NSObject
{
  public static final _Class CLASS = Rococoa.createClass("IKPictureTaker", _Class.class);

  public interface _Class extends NSClass
  {
    /**
     * Returns a shared {@code IKPictureTaker} instance, creating it if necessary.
     * @return an {@code IKPictureTaker} object.
     */
    IKPictureTaker pictureTaker();
  }

  NSInteger runModal();
}

public class IKPictureTakerTest extends JFrame
{
  public static void main(String[] args) throws Exception
  {
    // You need a GUI before this will work.
    new IKPictureTakerTest().setVisible(true);

    NSAutoreleasePool pool = NSAutoreleasePool.new_();

    // Initialize the Quartz framework.
    Quartz.instance.toString();

    // Display the dialog.
    IKPictureTaker pictureTaker = IKPictureTaker.CLASS.pictureTaker();
    NSInteger result = pictureTaker.runModal();

    if (result.intValue() == 0) // NSCancelButton
    {
      System.out.println("User cancelled.");
    }
    else
    {
      assert result.intValue() == 1; // NSOKButton
      System.out.println("User chose an image.");
    }

    System.out.println(pictureTaker.inputImage()); // null if the user cancelled

    pool.release();
  }
}