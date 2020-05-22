@Override
  public int compare(Integer o1, Integer o2) {
      int len1 = o1.toString().length();
      int len2 = o2.toString().length();
      if (len1==len2) {
          return o1.compareTo(o2);
      } else {
          return len1-len2;
      }
  }