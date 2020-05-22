@ViewScoped
public class ViewBean implements Serializable{
  private transient KPIDAO kpiDAO = //get singleton instance from factory
  //also dont keep connection object as instance variable, fetch it from pool in methods and perform db operations.

  private void readObject(java.io.ObjectInputStream stream)
        throws java.io.IOException, ClassNotFoundException
    {
        stream.defaultReadObject();

        // assign reference manually.
        this.kpiDAO  =  //get from factory;
    }

private void writeObject(java.io.ObjectOutputStream stream)
        throws java.io.IOException
    {

        stream.defaultWriteObject();
    }
}