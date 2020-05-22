int commonMin = Integer.MAX_INTEGER;
for (int i=0; i<b.length; i++) {
  if (Arrays.asList(a).contains(b[i])) {
    if (b[i] < commonMin){
      commonMin = b[i];
    }
  }
}
System.out.print(commonMin);