private static void recursiveExplore(List<DirCategory> categories, int depth) {
    if (depth == 0) return;

    for (DirCategory c1 : categories) {
        c1.setCount(dirEntryService.getDirEntryCategoryCount(c1));
        log.debug("c1: "+c1.getCount()+" - "+c1.getName());
        dirCategoryService.persist(c1);

        recursiveExplore(c1.getChildren(), depth - 1);
    }
}
public static void explore(List<DirCategory> categories) {
    recursiveExplore(categories, 5);
}