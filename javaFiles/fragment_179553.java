list = list
   .replaceAll("A", "X") // Assuming someone hasn't invented an X base.
   .replaceAll("G", "A")
   .replaceAll("X", "G")
   .replaceAll("C", "X")
   .replaceAll("T", "C")
   .replaceAll("X", "T")
   ;

/* **Edit:** I think I've got that the right way around now. */