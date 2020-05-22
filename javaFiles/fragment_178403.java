int sequenceLength = 3;
    for (int i = 0; i <= M.length - sequenceLength; i++) {
        boolean correct = true;
        for (int j = 0; j < sequenceLength && (correct = (M[i] == M[j+i])); j++);

        if (correct){
            ValuePoint = 0;
        } else {
            PExtraM = i;
            ValuePoint = 30;
            break;
        }
    }