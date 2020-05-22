public static int allignment(String dnaSequence1, String dnaSequence2 /*,int offset*/) {
    int bestScore = -1;
    int bestOffset = 0;
    String bestSequence = null;

    for(String tempSequence = dnaSequence2; tempSequence.length() > 0; tempSequence = tempSequence.substring(1)) {
        for(String match = tempSequence; match.length() > 0; match = match.substring(0, match.length() - 1)) {
            int matchIndex;
            if (-1 != (matchIndex = dnaSequence1.indexOf(match))) {
                if (match.length() > bestScore) {
                    bestOffset = matchIndex;
                    bestScore = match.length() ;
                    bestSequence = match;
                    break;
                }
            }
        }
        if (null != bestSequence && bestScore > tempSequence.length()) {
            break; // don't bother checking any shorter sequences, we already have a better match
        }
    }

    if (null != bestSequence) {
        System.out.println("Best alignment score :" + bestScore);
        System.out.println(dnaSequence1);
        System.out.print(space(bestOffset) + bestSequence);
    } else {
        System.out.print(dnaSequence1+" and "+dnaSequence2+" cannot be aligned");
    }

    int alignmentScore = dnaSequence1.compareToIgnoreCase(dnaSequence2);

    return alignmentScore;
}

public static String space(int bestOffset) {
    StringBuilder builder = new StringBuilder();

    for (int i = 0; i < bestOffset; i++) {
        builder.append(" ");
    }
    return builder.toString();
}