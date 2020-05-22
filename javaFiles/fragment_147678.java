public static int DNAChains(String base) {

if (base == null || base.length() == 0) {
    return 0;
}

int curSequence = 0;
int totalSolutions = 1;
boolean inSequence = false;
//flag to check whether there are any sequences present.
//if not, there is one solution rather than 0
char prevChar = 'x';
char follChar = 'y';
int i = 0;

char[] chars = base.toCharArray();

//handle starting sequence if present
while (i < chars.length && chars[i] == '?') {
    curSequence++;
    i++;
}

if (curSequence > 0) {

    //exclusively ?'s needs to be treated even differently
    if (i < chars.length) {
        //? at the edge can be anything, so 3*false, 1*true
        //if length is 1 though, there are just 3 solutions
        totalSolutions *= (curSequence > 1) ? 3 * solveSequence(curSequence - 1, false) + solveSequence(curSequence - 1, true) : 3;
        curSequence = 0;
    } else {
        //result is 4*3^(length-1)
        totalSolutions = 4* ((int) Math.pow(3, chars.length-1));
    }
}

//check for sequences of question marks
for (; i < chars.length; i++) {

    if (chars[i] == '?') {
        if (!inSequence) {
            inSequence = true;
            prevChar = chars[i - 1];

            //there is at least one sequence -> set flag
        }
        curSequence++;
    } else if (inSequence) {
        inSequence = false;
        follChar = chars[i];
        totalSolutions *= solveSequence(curSequence, prevChar == follChar);
        curSequence = 0;
    }

}

//check if last sequence ends at the edge of the string
//if it does, handle edge case like in the beginning
if (inSequence) {
    //? at the edge can be anything, so 3*false, 1*true
    //if length is 1 though, there are just 3 solutions
    totalSolutions *= (curSequence > 1) ? 3 * solveSequence(curSequence - 1, false) + solveSequence(curSequence - 1, true) : 3;
}

return totalSolutions;
}//end DNAChains

private static int solveSequence(int length, boolean prevFollEqual) {

if (prevFollEqual) {
    //anchor
    if (length == 1) {
        return 3;
    } else {
        return 3 * solveSequence(length - 1, false);
    }
} else {
    //anchor
    if (length == 1) {
        return 2;
    } else {
        return 2 * solveSequence(length - 1, false) + solveSequence(length - 1, true);
    }
}
}//end solveSequence