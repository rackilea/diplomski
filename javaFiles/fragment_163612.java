Optional<String> optionalCategoryName = Optional.ofNullable(order).map(Order::getItem)
        .map(Item::getCategory).map(Category::getCategoryName);

if (optionalCategoryName.isPresent()) {
    System.out.println("Category Name is present and is " + optionalCategoryName.get());
}