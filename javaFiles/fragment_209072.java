import org.apache.commons.lang.StringUtils;

String protein; // the full sequence
String part; // your search string
int bestScore = Integer.MAX_VALUE;
int bestLocation = 0;
String bestSeqence = "";
for (int i = 0; i < protein.length() - part.length(); i++) {
    String sequence = protein.substring(i, part.length());
    int score = StringUtils.getLevenshteinDistance(sequence, part);
    if (score < bestScore) {
        bestScore = score;
        bestLocation = i;
        bestSeqence = sequence;
    }
}

// at this point in the code, the "best" variables will have data about the best match.