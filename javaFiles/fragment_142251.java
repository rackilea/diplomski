interface ViewSorterFactory {
   ViewSorter create();
}
class IdeaTableSorterFactory implements ViewSorterFactory {
   ViewSorter create() { return new IdeaTableSorter(); }
}
class FooTableSorterFactory implements ViewSorterFactory {
   ViewSorter create() { return new FooSorter(); }
}