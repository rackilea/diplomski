String name = String.format("%s %s", bankarray[count].getFirst(), bankarray[count].getLast());

// Added 12+17=29 as padding
ps.printf("%s-29s", name);
// Removed padding enteirely
ps.printf("%d", bankarray[count].getSoNumber());