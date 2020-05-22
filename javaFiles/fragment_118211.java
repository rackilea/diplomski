Polynomial looptemp = temp;
    while(looptemp != null) {
        looptemp.coefficient = thisClone.coefficient*looptemp.coefficient;
        looptemp = looptemp.successor;
    }
    result = result.plus(temp);