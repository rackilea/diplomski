ArrayList<Integer> data = new ArrayList<Integer>();

ResultSet rs = ....;

// For each record in the result...    
while (rs.next()) {
  // Want more values? Create a custom Type representing the Row!
  // The following is just an example taking the first column (as an int).
  // This would be done manually for each column... and possibly loadeded
  // in a custom object which is then added to the list... blah blah.
  // (Alternatively each row could be represented as Object[] or List<Object>
  //  at the expense of losing static typing.)
  int id = rs.getInt(0);
  data.add(id);
}

// Then later, if you *really* want an array...
// (Java is such a backwards language and lacks a trivial way
//  to go to int[] from Integer[] but I digress...)
Integer[] array = data.toArray(new Integer[0]);