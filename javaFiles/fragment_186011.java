private ArrayAdapter(@NonNull Context context, 
        @LayoutRes int resource,
        @IdRes int textViewResourceId, 
        @NonNull List<T> objects, 
        boolean objsFromResources) {
    …
    mObjects = objects;
    …
}