public String toString() {
        StringBuilder sb = new StringBuilder("Contents of list: {");

        appendRecursion(sb, 0);
        return sb.toString();
      }
      private void appendRecursion(StringBuilder result, int pos) {
        if (pos != size()) {
          rotate();
          result.append(get().getData()).append(",");
          pos = pos + 1;
          appendRecursion(result, pos);
        }     
      }