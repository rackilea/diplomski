for (Ticket t : tickets) {
  if (!t.getPurchased()) {
    theDateArray.add(t.getDate());
  }
}
for (String date : theDateArray) {
  System.out.println(date + " ");
}