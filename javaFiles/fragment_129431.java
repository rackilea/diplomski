/**
 * Root of class hierarchy.
 */
public interface InventoryItem {
}

/**
 * Additional "parallel" interface implemented by some (but not all)
 * InventoryItems and other non-inventory items.
 */
public interface Usable {
  void use();
}

/**
 * A Spell is in InventoryItem and is also Usable.
 */
public abstract class Spell implements InventoryItem, Usable {
}

public class Gremlin extends Spell {
}

/**
 * A Door is *not* an InventoryItem but can be used.
 */
public class Door implements Usable {
}