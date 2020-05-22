List<Object> inputList; // List containing all kinds of objects
List<Integer> newList = new ArrayList<>();

for (Object o: inputList) {
     if (o instanceof String) {
        String s = (String) o;
        try {
            int n = Integer.parseInt(s)
            if (n >= 0 && n <= 23) {
               newList.add(n);
            }
        } catch (NumberFormatException e) {
         System.out.println(s + " is not an integer");
        }
     }
     else if (o instanceof Integer) {
        int n = (Integer)o;
        if (n >= 0 && n <= 23) {
           newList.add(n);
        }
     }
}