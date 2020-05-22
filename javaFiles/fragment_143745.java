public class WonderCardProvider {
    private static final WonderCard[] cards = new WonderCard[] {
        new WonderCard(0,"Olympia","La Statue de zeus à Olympie",R.mipmap.wondercard_0),
        ..
    };

    public static WonderCard[] getAllCards() {
        return cards;
    }
}
// Note that the `getAllCards()` should probably return in as unmodifiable (thus returning a collection instead of array).

card = WonderCardProvider.getAllCards();