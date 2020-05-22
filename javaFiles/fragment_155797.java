public class ArrayList<E> extends AbstractList<E>
     implements List<E>, RandomAccess, Cloneable, java.io.Serializable
 {
 private static final long serialVersionUID = 8683452581122892189L;


/** The array buffer into which the elements of the ArrayList are stored. 
 *  The capacity of the ArrayList is the length of this array buffer. 
 */

 private transient Object[] elementData;