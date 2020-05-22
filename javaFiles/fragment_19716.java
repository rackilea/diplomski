int anArray[] = new int[] { 99, 100};

doStuff(anArray);
...

//inside doStuff 
anArray = new int[] { 68, 69};

...
// back in anArray's original scope
System.out.println(anArray[1]); // still outputs 100, not 69