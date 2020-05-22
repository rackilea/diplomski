/**
 * Tries to find a category by its id.
 *
 * @param id the id
 * @return the category for that id or {@code null} if not found
 */
@Nullable
public Category findCategoryById(int id) {
    Object result = ....uniqueResult();
    return (Category) result;
}