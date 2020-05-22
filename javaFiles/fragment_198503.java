volatile int state;  

Integer   result;

void succeed(Integer result)
    if(state==PENDING)              vr0
        this.result = result;        w1
        state = DONE;               vw1

Integer peekResult()
    if(state==DONE)                 vr2 
        return result;               r2
    return null;