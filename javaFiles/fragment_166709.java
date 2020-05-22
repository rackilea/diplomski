class Item {
    int relativeProb;
    String name;

    //Getters Setters and Constructor
}

...

class RandomSelector {
    List<Item> items = new List();
    Random rand = new Random();
    int totalSum = 0;

    RandomSelector() {
        for(Item item : items) {
            totalSum = totalSum + item.relativeProb;
        }
    }

    public Item getRandom() {

        int index = rand.nextInt(totalSum);
        int sum = 0;
        int i=0;
        while(sum < index ) {
             sum = sum + items.get(i++).relativeProb;
        }
        return items.get(Math.max(0,i-1));
    }
}