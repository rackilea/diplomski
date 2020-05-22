flush() {
    switch (PEEPHOLESTATE) {
        EMPTY: break;
        PUSHK: emit(PUSHK,FIRSTCONSTANT);
               break;
        PUSHKPUSHK:
               emit(PUSHK,FIRSTCONSTANT),
               emit(PUSHK,SECONDCONSTANT),
               break:
      }
      PEEPHOLESTATE=EMPTY;
      return; }