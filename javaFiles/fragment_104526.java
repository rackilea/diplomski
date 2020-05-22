boolean[] taken = new boolean[7]; //(0-6 inclusive)
// You were never using the key as far as I could see...
for (Data data : list.values()) {
   if (data.getRoom() == 1 && data.getName().equalsIgnoreCase("RED")) {
       taken[data.getPosition()] = true;
   }
}

for (int i = 1; i <= 6; i++) {
    if (!taken[i]) {
        return i;
    }
}

// Do whatever you want if there are no free positions...