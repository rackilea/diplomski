GeneratePUSHK:
    switch (PEEPHOLESTATE) {
        EMPTY: PEEPHOLESTATE=PUSHK;
               FIRSTCONSTANT=K;
               break;
        PUSHK: PEEPHOLESTATE=PUSHKPUSHK;
               SECONDCONSTANT=K;
               break;
        PUSHKPUSHK:
        #IF consumeEmitLoadK // flush state, transition and consume generated instruction
               emit(PUSHK,FIRSTCONSTANT);
               FIRSTCONSTANT=SECONDCONSTANT;
               SECONDCONSTANT=K;
               PEEPHOLESTATE=PUSHKPUSHK;
               break;
        #ELSE // flush state, transition, and reprocess generated instruction
               emit(PUSHK,FIRSTCONSTANT);
               FIRSTCONSTANT=SECONDCONSTANT;
               PEEPHOLESTATE=PUSHK;
               goto GeneratePUSHK;  // Java can't do this, but other langauges can.
        #ENDIF
     }

  GenerateADD:
    switch (PEEPHOLESTATE) {
        EMPTY: emit(ADD);
               break;
        PUSHK: emit(PUSHK,FIRSTCONSTANT);
               emit(ADD);
               PEEPHOLESTATE=EMPTY;
               break;
        PUSHKPUSHK:
               PEEPHOLESTATE=PUSHK;
               FIRSTCONSTANT+=SECONDCONSTANT;
               break:
     }  

  GeneratePOPX:
    switch (PEEPHOLESTATE) {
        EMPTY: emit(POP,X);
               break;
        PUSHK: emit(MOV,X,FIRSTCONSTANT);
               PEEPHOLESTATE=EMPTY;
               break;
        PUSHKPUSHK:
               emit(MOV,X,SECONDCONSTANT);
               PEEPHOLESTATE=PUSHK;
               break:
     }

GeneratePUSHVARX:
    switch (PEEPHOLESTATE) {
        EMPTY: emit(PUSHVAR,X);
               break;
        PUSHK: emit(PUSHK,FIRSTCONSTANT);
               PEEPHOLESTATE=EMPTY;
               goto GeneratePUSHVARX;
        PUSHKPUSHK:
               PEEPHOLESTATE=PUSHK;
               emit(PUSHK,FIRSTCONSTANT);
               FIRSTCONSTANT=SECONDCONSTANT;
               goto GeneratePUSHVARX;
     }