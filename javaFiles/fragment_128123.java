private void initSaveOrUpdateEventListenerHook(Configuration config) {
    List<SaveOrUpdateEventListener> l = new ArrayList<SaveOrUpdateEventListener>();
    SaveOrUpdateEventListener[] listeners =
            config.getEventListeners().getSaveOrUpdateEventListeners();
    l.add(new SaveOrUpdateEventListenerHook());
    l.addAll(Arrays.asList(listeners));
    SaveOrUpdateEventListener[] newListeners = l.toArray(new SaveOrUpdateEventListener[l.size()]);
    config.getEventListeners().setSaveOrUpdateEventListeners(newListeners);
}