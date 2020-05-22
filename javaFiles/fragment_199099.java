import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;

public class ClassHierarchy {
 public ClassHierarchy() {
  childToParentMap = new Hashtable();
  parentToChildMap = new Hashtable();
  parentToChildMap.put(Object.class, new Vector());
 }

 public boolean addClass(Class toAdd) {
  if (toAdd.isInterface()) return false;
  if (toAdd.equals(Object.class)) return false;
  if (childToParentMap.get(toAdd) != null) return false;

  addClassBelow(toAdd, Object.class, new Vector());
  return true;
 }

 public Class getParent(Class subclass) {
  return (Class) childToParentMap.get(subclass);
 }

 private void addClassBelow(Class toAdd, Class parent, Vector initialChildren) {
  Vector children = (Vector) parentToChildMap.get(parent);
  Class reparented;
  do {
   reparented = null;
   for (Enumeration childEnum = children.elements();
        childEnum.hasMoreElements();
        ) {
    Class child = (Class) childEnum.nextElement();
    if (child.isAssignableFrom(toAdd)) {
     addClassBelow(toAdd, child, initialChildren);
     return;
    } else if (toAdd.isAssignableFrom(child)) {
     children.removeElement(child);
     initialChildren.addElement(child);
     childToParentMap.put(child, toAdd);
     // Guard against concurrent modification
     reparented = child;
     break;
    }
   }
  } while (reparented != null);

  children.addElement(toAdd);
  childToParentMap.put(toAdd, parent);
  parentToChildMap.put(toAdd, initialChildren);
 }


 private Hashtable childToParentMap;

 private Hashtable parentToChildMap;
}