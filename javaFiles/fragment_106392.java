public void setY();
    Code:
       0: aload_0       
       1: getfield      #2                  // Field a:LA;
       4: invokevirtual #3                  // Method A.getX:()I
       7: istore_1      
       8: iload_1       
       9: ifge          17
      12: aload_0       
      13: iload_1       
      14: putfield      #4                  // Field y:I
      17: return        
}