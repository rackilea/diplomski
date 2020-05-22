// removing elements
while (it.hasNext()) {
    boolean isPresent = false;
    ProductCategoryToProductAttributeRel nextRel = it.next() // I think you wanted to increment once per while loop?
    for (Integer paId : productCategoryDTO.getProductAttributeIds()) {
        if (nextRel.getProductAttribute().getId().equals(paId)) {
            isPresent = true; break;
        }
    }
    if (!isPresent) { it.remove(); }
}