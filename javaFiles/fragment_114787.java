ArrayList<Fish> fishes = new ArrayList<Fish>();

public void add(Fish fish)
{
    // if the ArrayList contains less than the total number of allowed fishes
    if (fishes.size() < this.numFish) {
        fishes.add(fish);
    }
}