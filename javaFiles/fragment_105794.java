(main class, main method)
search(list, "Test");
list = delete(list, "Test");

(the class where the methods are located)
public void search(List<String> list, String searchElement) { ... }

public List<String> delete(List<String> list, String elementToDelete) {
      // delete element
      return list;
}