class CandidatesList { 
    private Candidate[] candidates;

    public CandidatesList(Candidate[] candidates) {
        this.candidates = candidates;
    }

    public int getTotal()
    {
        int total = 0;
        for( Candidate candidate : candidates) {
            total += candidate.votes();
        }
        return total;
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();
        int total = getTotal();
        for( Candidate candidate : candidates) {
            builder.append( String.format( "%20s | %5d | %.2f %%\n", 
                candidate.getName(), candidate.votes(), candidate.votes() / total );
        }
        return builder.toString();
    } 
}