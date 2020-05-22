// java.awt.Color[r=128,g=32,b=212]
System.out.println(parse("rgb(128,32,212)"));     

// java.awt.Color[r=255,g=0,b=255]                         
System.out.println(parse("rgb (255, 0, 255)"));   

// throws IllegalArgumentException: 
// Color parameter outside of expected range: Red Blue
System.out.println(parse("rgb (256, 1, 300)"));