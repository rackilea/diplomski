public class CustomerDomain
{
    private int customerNumber;
    private int customerDomainID;
    private List<Double> scores = new ArrayList<Double>();

    public CustomerDomain(int number, int domainID)
    {
        this.customerNumber = number;
        this.customerDomainID = domainID;
    }

    public void addScore(double score)
    {
        this.scores.add(score);
    }
    public List<Double> getScores()
    {
        return this.scores;
    }
}