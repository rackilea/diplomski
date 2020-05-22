int times = 0;
try {
  times = Integer.parseInt(args[1]);
} catch (Exception e) {
  System.out.println("failure with a parameter");
}