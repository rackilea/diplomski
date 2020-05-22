boolean hasX = false;
boolean hiCount = 0;

for (Wire wire : inputs) {
    Signal inputSignal = wire.getSignal();

    if (inputSignal == Signal.X) {
        hasX = true;
        // optimization: break out of the loop early since we know
        // that, whatever the number of HI and LO, if there is one
        // X, the result is X
        break;
    }
    else if (inputSignal == Signal.HI) 
        hiCount++;
    }
}

if (hasX) {
    getOutput().setSignal(Signal.X);
}
else if (hiCount == 1) {
    getOutput().setSignal(Signal.HI);
}
else {
    getOutput().setSignal(Signal.LO);
}