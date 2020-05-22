int num = 0;
  String[] a = s1.split(" ");
  String[] b = s2.split(" ");

  for (int i = 0; i < a.length; i++) {
      for (int j = 0; j < b.length; j++) {
          if (a[i].equals(b[j])) {
              num++;
          }
      }
  }

  return num;