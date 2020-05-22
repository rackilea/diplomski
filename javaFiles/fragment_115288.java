/**
 * Resolve a category by its id.
 *
 * @param id the id as given by another method
 * @return the category for that id 
 * @throws NoSuchElementException if the element does not exist
 */
@Nonnull
public Category getCategoryById(int id) {
    Object result = ....uniqueResult();
    if (result == null) {
      throw new NoSuchElementException("category for id: " + id);
    }
    return (Category) result;
}