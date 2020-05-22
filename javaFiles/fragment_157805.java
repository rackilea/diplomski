public interface BWidgetObject<D> extends Comparable<BWidgetObject<D>> {
}

public class BItemDtoWidgetObject implements BWidgetObject<ItemDto> {
    // ...

    @Override
    public int compareTo(BWidgetObject<ItemDto> other) {
        // ...
    }
}