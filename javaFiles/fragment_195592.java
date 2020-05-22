//class A
public class A implements Cloneable{
B [] array;
.
.
.
public Object clone() throws CloneNotSupportedException {

         A copyA = null;
         try {
             copyA = (A) super.clone();
            }
            catch (CloneNotSupportedException e) {
                // this should never happen
                throw new InternalError(e.toString());
            }
         copyA.array = array.clone();

         for (int i=0;i<array.length;i++)
         copyA.array[i] = (B) array[i].clone();

         return copyA;
 }
}

//class B
public class B implements Cloneable{
Node topnode;
Node bottom;
.
.
.
public Object clone() throws CloneNotSupportedException {
         B copyB = null;
         try {
             copyB= (B) super.clone();
            }
            catch (CloneNotSupportedException e) {
                // this should never happen
                throw new InternalError(e.toString());
            }

            return copyB;
 }
}

//class Node
public class Node implements Cloneable{

.
.
.
.
     public Object clone() throws CloneNotSupportedException {
         Node copyNode = null;
         try {
             copyNode = (Node) super.clone();
            }
            catch (CloneNotSupportedException e) {
                // this should never happen
                throw new InternalError(e.toString());
            }
         return copyNode;
 }

}

/*in your main class 
if you already have you original object of class A lets say original
and you want to clone it to copy you just do */

A copy =(A) original.clone();