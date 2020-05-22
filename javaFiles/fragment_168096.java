public void setCategories(Collection<String> categories)
{
    for(String cat:this.category.toArray(new String[0])){//using toArray to avoid ConcurrentModificationException
        removeCategory(cat);
    }
    if (categories != null)
    {
        for(String cat:categories){
            addCategory(cat);
        }
    }
}