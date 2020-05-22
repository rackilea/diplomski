public void setY();
    Code:
       0: aload_0       
       1: getfield      #2                  // Field a:LA;
       4: invokevirtual #3                  // Method A.getX:()I
       7: ifge          21
      10: aload_0       
      11: aload_0       
      12: getfield      #2                  // Field a:LA;
      15: invokevirtual #3                  // Method A.getX:()I
      18: putfield      #4                  // Field y:I
      21: return        
}