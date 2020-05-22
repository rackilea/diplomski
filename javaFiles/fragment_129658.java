private Category parent;
private Set<Category> subCategories;

public Set<Category> getSubCategories() {
    Set<Category> result;
    if (depthLimit.get() == null || getDepth() < depthLimit.get()) {
        result = subCategories;
    } else {
        result = null;
    }
    return result;
}

public int getDepth() {
    return parent != null? parent.getDepth() + 1 : 0;
}

private static ThreadLocal<Integer> depthLimit = new ThreadLocal<>();

public static void limitSubCategoryDepth(int max) {
    depthLimit.set(max);
}

public static void unlimitSubCategory() {
    depthLimit.remove();
}