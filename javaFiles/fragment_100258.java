import org.chocosolver.util.tools.ArrayUtils; 
//....
for (int m = 0; m < nMeetings; m++) {
    IntVar[] colm = ArrayUtils.getColumn(agent_cal, m);
    ArrayList<Integer> as = meet_attend.get(m);
    for (int a = 0; a < as.size() - 2; a++) {
        solver.post(ICF.arithm(
                colm[a],
                "=",
                colm[a+1]));
    }
}