public static int mirrorRecursive(Integer value){
  System.out.print(value);
  if (value > 1) {
    mirrorRecursive(value - 1);
  }
  System.out.print(value);

  return value;
}