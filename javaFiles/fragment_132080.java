// outside code
public static final String ANSI_CSI = "\x1b[";
// inside code
System.out.println("First line of text");
System.out.println("[  5/365]");
System.out.print(ANSI_CSI + "2A"); // up 2 lines
System.out.println("Different first line of text");
System.out.println("[ 11/365)");
System.out.print(ANSI_CSI + "A"); // up line
System.out.print(ANSI_CSI + "2K"); // erase all of line
System.out.print(ANSI_CSI + "A"); // up line
System.out.print(ANSI_CSI + "K"); // erase after cursor
System.out.println("Line one");
System.out.println("[240/365]");