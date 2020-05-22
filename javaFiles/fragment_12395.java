String[] items = test.split(",");
int[] arr = new int[items.length];
  for (int i = 0; i < items.length; i++) {
    try {
       arr[i] = Integer.parseInt(items[i]);
         } catch (NumberFormatException nfe) {};
  }