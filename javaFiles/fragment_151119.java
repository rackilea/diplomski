enum StaticData implement IData {
    INSTANCE; // only one instance

    /* put your non static fields here */

    /* put your methods for IData here */
}

public enum BuildingType {
    MINER("Miner", "A basic slave.", StaticData.INSTANCE), FARM("Farm", "Old Macdonald's Crib."), BAKERY("Bakery", "Best Cookies in Town!"), FACTORY("Factory", "Highest Quality Memes in town!"), QUARRY("Quarry", "Let's get drilling!");

// later
BuildingType.MINER.getIData().setCookiesPerSecond(4);