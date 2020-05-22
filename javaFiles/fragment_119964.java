void method1();
   Code:
      0: dconst_1
      1: invokestatic  #2                  // Method java/lang/Double.valueOf:(D)Ljava/lang/Double;
      4: astore_1
      5: aload_1
      6: invokevirtual #3                  // Method java/lang/Double.doubleValue:()D
      9: ldc2_w        #4                  // double 2.0d
     12: dmul
     13: invokestatic  #2                  // Method java/lang/Double.valueOf:(D)Ljava/lang/Double;
     16: astore_2
     17: return

 void method2();
   Code:
      0: dconst_1
      1: invokestatic  #2                  // Method java/lang/Double.valueOf:(D)Ljava/lang/Double;
      4: astore_1
      5: aload_1
      6: invokevirtual #3                  // Method java/lang/Double.doubleValue:()D
      9: ldc2_w        #4                  // double 2.0d
     12: dmul
     13: invokestatic  #2                  // Method java/lang/Double.valueOf:(D)Ljava/lang/Double;
     16: astore_2
     17: return