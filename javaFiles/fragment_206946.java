class ArrayIndexComparator implements Comparator<Integer>
{
    private Float[] scores;

    public ArrayIndexComparator(float[] scores)
    {
        this.scores = new Float[scores.length];
        for(int i=0; i<scores.length; i++){
            this.scores[i] = scores[i];
        }
    }

    public Integer[] createIndexArray()
    {
        Integer[] indexes = new Integer[scores.length];
        for (int i = 0; i < scores.length; i++)
        {
            indexes[i] = i;
        }
        return indexes;
    }

    @Override
    public int compare(Integer index1, Integer index2)
    {
        // Autounbox from Integer to int to use as array indexes
        return scores[index1].compareTo(scores[index2]);
    }

    public static void main(String[] args){
        float[] scoreRanks = new float[]{2.0f,3.0f,1.0f};
        ArrayIndexComparator comparator = new ArrayIndexComparator(scoreRanks);
        Integer[] indexes = comparator.createIndexArray();
        Arrays.sort(indexes, comparator);
        int[] ranking = new int[indexes.length];
        for (int i = 0; i < ranking.length; i++) {
            ranking[indexes[i]] = i + 1;
        }
        for (int i = 0; i < ranking.length; i++){
            System.out.println(ranking[i]+" "+scoreRanks[i]);
        }
        // Will print:
        // 2.0 2
        // 3.0 3
        // 1.0 1
    }
}

public Ranking(String[] names, float[] scores) {
    nameTest = new Cities[names.length];
    rankTest = new Cities[names.length];
    city = new Cities[names.length];
    scoreRanks = new Float[scores.length];
    for (int i = 0; i < scores.length - 1; i++) {
        if (scores[i] == scores[i + 1])
            throw new IllegalArgumentException();
    }
    if (names == null || scores == null)
        throw new NullPointerException();
    if (names.length != scores.length)
        throw new IllegalArgumentException();
    for (int p = 0; p < scoreRanks.length; p++) {
        scoreRanks[p] = scores[p];
    }
    // This is the updated part
    ArrayIndexComparator comparator = new ArrayIndexComparator(scoreRanks);
    Integer[] indexes = comparator.createIndexArray();
    Arrays.sort(indexes, comparator);
    int[] ranking = new int[indexes.length];
    for (int i = 0; i < ranking.length; i++) {
        ranking[indexes[i]] = i + 1;
    }
    // Up until this part
    for (int i = 0; i < ranking.length; i++) {
        city[i] = new Cities(names[i], ranking[i]);
        nameTest[i] = new Cities(names[i], ranking[i]);
        rankTest[i] = new Cities(names[i], ranking[i]);
    }
    Arrays.sort(nameTest, Cities.BY_NAME);
    Arrays.sort(rankTest, Cities.BY_RANK);
    for (int i = 0; i < names.length - 1; i++) {
        if (nameTest[i].getName().equals(nameTest[i + 1].getName())
                || nameTest[i].getName() == null
                || rankTest[i].getRank() == rankTest[i + 1].getRank())
            throw new IllegalArgumentException();
    }
}