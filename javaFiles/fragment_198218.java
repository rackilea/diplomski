import java.util.ArrayList;
import java.util.Collection;
import java.util.Enumeration;
import java.util.NoSuchElementException;


@SuppressWarnings("unchecked")
public class SerializableEnumeration
   extends ArrayList
   implements Enumeration
{
   /** The serialVersionUID */
   private static final long serialVersionUID = 8678951571196067510L;
   private int index;

   public SerializableEnumeration () {
      index = 0;
   }

   public SerializableEnumeration (Collection c) {
      super(c);
      index = 0;
   }

   public SerializableEnumeration (int initialCapacity) {
      super(initialCapacity);
      index = 0;
   }

   public boolean hasMoreElements() {
      return (index < size());
   }

   public Object nextElement() throws NoSuchElementException
   {
      try {
         Object nextObj = get(index);
         index++;
         return nextObj;
      }
      catch (IndexOutOfBoundsException e) {
         throw new NoSuchElementException();
      }
   }

   private void writeObject(java.io.ObjectOutputStream out)
      throws java.io.IOException
   {
      // the only thing to write is the index field
      out.defaultWriteObject();
   }

   private void readObject(java.io.ObjectInputStream in)
      throws java.io.IOException, ClassNotFoundException
   {
      in.defaultReadObject();
   }
}