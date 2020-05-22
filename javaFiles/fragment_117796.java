Color c1 = new Color(0,0,0);
Color c2 = new Color(0,0,0);

if (c1 == c2) {
   System.out.println("Will never get here");
}

if (c1.equals(c2)) {
   System.out.println("The colours (including alpha) are the same.");
}