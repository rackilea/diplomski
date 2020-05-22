class BoxList implements Iterable<Box> { ... }
class BoxIterator implements Iterator<Box> { ... }

BoxList boxList = ...;
for (Box box : boxList) {
  for (Drawer drawer : box) {
    drawer.getId()
  }
}