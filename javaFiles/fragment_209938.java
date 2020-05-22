@Parcel
public class Item {
    @ParcelPropertyConverter(ItemListParcelConverter.class)
    public List<Item> itemList;
}
@Parcel public class SubItem1 extends Item {}
@Parcel public class SubItem2 extends Item {}

public class ItemListParcelConverter implements ParcelConverter<List<Item>> {
    @Override
    public void toParcel(List<Item> input, Parcel parcel) {
        if (input == null) {
            parcel.writeInt(-1);
        }
        else {
            parcel.writeInt(input.size());
            for (Item item : input) {
                parcel.writeParcelable(Parcels.wrap(item), 0);
            }
        }
    }

    @Override
    public List<Item> fromParcel(Parcel parcel) {
        int size = parcel.readInt();
        if (size < 0) return null;
        List<Item> items = new ArrayList<Item>();
        for (int i = 0; i < size; ++i) {
            items.add((Item) Parcels.unwrap(parcel.readParcelable(Item.class.getClassLoader())));
        }
        return items;
    }
}