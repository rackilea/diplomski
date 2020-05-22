for (int ascii = 43, i = 1; ascii <= 120; ascii++) {
     System.out.print((char)ascii + "  ");

     if (i++ % 15 == 0)
     {
          System.out.println();
     }
}