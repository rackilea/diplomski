public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
    loaderManager = getLoaderManager();
    loaderManager.initLoader(1, null, this);

    return super.onCreateView(inflater, container, savedInstanceState);
}