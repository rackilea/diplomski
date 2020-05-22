public int getTotal(Candidate[] election)
{
    int total = 0;
    for( Candidate candidate : election ) {
        total += candidate.votes();
    }
    return total;
}