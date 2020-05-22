public interface Section {
    List<? extends Item> getItems();
}

public interface SectionEvolution extends Section {
    // Or List<? extends ItemEvolution> if you might want to override this again.
    List<ItemEvolution> getItems();
}