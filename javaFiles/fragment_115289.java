/**
 * Finds a category by its id.
 *
 * @param id the id
 * @return the category for that id, an empty value if not found
 */
public Optional<Category> findCategoryById(int id) {
    Object result = ....uniqueResult();
    return Optional.ofNullable((Category) result);
}