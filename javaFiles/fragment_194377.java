int x = 0;
for (x = 0; x < 10; x = x + 1)
    System.out.println(x);

int y = 0;
for (y = 0; y < 10; y = y + 1)
    /* Lalala... does nothing at all... */;
System.out.println(y); // When control flow gets here, y equals 10