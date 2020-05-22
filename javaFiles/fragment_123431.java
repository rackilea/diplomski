public class Prices {
    Integer price_1;
    Integer price_2;

    public List<Integer> getAllPrices() {
        List<Integer> allPrices = new ArrayList<Integer>();
        allPricess.add(price_1);
        allPrices.add(price_2);
        return allPrices;
    }
    public Integer getPrice(int priceNumber) {
        if (priceNumber == 1) {
            return price_1;
        }
        // etc...
    }
}