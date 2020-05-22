for(int i = 0; i<numTimesToRepeat; i++){    
    System.out.print("Print line " + i);
    System.in.read();
    System.out.print("\u001b[1A");
    System.out.print("\r");
}