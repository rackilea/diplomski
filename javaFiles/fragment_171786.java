public String toString() {
      Node tmp = head;

      String result = "";
      while (tmp != null) {
          result += tmp.toString() + " ";
          tmp = tmp.getNext();
      }

      return result;
  }