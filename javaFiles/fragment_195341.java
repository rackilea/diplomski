StringBuilder sb = new StringBuilder();
    curr = head;
    for(int i=0; i<listSize; i++) {
      sb.append(curr.next().toString());
    }
    return "[" + sb.toString() + "]";