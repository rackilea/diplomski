public Elements build() {
        java.util.Set<Integer> items;
        switch (this.items == null ? 0 : this.items.size()) {
        case 0: 
            items = java.util.Collections.emptySet();
            break;

        case 1: 
            items = java.util.Collections.singleton(this.items.get(0));
            break;

        default: 
            items = new java.util.LinkedHashSet<Integer>(this.items.size() < 1073741824 ? 1 + this.items.size() + (this.items.size() - 3) / 3 : java.lang.Integer.MAX_VALUE);
            items.addAll(this.items);
            items = java.util.Collections.unmodifiableSet(items);
        }
        return new Elements(items, b);
    }