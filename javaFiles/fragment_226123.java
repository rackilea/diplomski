public abstract class Pizza {
    final Set toppings;

    Pizza(Builder<?> builder) {
        toppings = builder.toppings.clone();
    }

    public enum Topping {HAM, MUSHROOM, ONION, PEPPER, SAUSAGE}

    abstract static class Builder<T extends Builder> {
        EnumSet toppings = EnumSet.noneOf(Topping.class);
        abstract Pizza build();

        public T addTopping(Topping topping) {
            toppings.add(Objects.requireNonNull(topping));
            return self();
        }

        // Subclasses must override this method to return "this"
        protected abstract T self();
    }
}