void foo()
  {
      if (!doA())
          GOTO exit;
      if (!doB())
          GOTO cleanupA;
      if (!doC())
          GOTO cleanupB;

      // everything succeed
      return;

  cleanupB:
      undoB();
  cleanupA:
      undoA();
  exit:
      return;
  }

  void undoB(){}
  void undoA(){}
  boolean doC(){return false;}
  boolean doA(){return false;}
  boolean doB(){return false;}