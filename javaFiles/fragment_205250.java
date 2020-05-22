class Merchant
{
    Map<Quality, Integer> ratings = new HashMap<Quality, Integer>();

    boolean hasQuality(Quality quality)
    {
        return ratings.containsKey(quality);
    }

    int getRatingOfQuality(Quality quality)
    {
        Integer rating = ratings.get(quality);
        return (rating != null) ? rating : 0;
    }

    void setRatingOfQuality(Quality quality, int rating)
    {
        ratings.put(quality, rating);
    }
}