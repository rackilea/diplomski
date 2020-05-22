public class CustomStack<T> {
    private class CustomNode {
      private T data;
      private CustomNode next;

      public CustomNode(T data) {
        this.data = data;
      }
    }
  }