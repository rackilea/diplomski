public Result getBestResultDouble(Participant p) {
    double best = 0;
    Result bestResult = null;

    if (hasResult(p)) {
        for (Result r : eventResults) {

            if (p.equals(r.getParticipant())) {

                double res = r.getResult();

                if (res > best) {
                    best = res;
                    bestResult = r;
                }
            }
        }
    }
    return bestResult;
}