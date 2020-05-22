public class Export extends AbstractHandler implements PropertyChangeListener {
    public Export() {
        Activator.getDefault().AddListener(this);
        setBaseEnabled(!getMySelection().isEmpty());
    }

    @Override
    public Object execute(ExecutionEvent event) throws ExecutionException {
        // My handler
        return null;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getPropertyName().equals(Activator.EVENT_SELECTION_CHANGED)) {
            boolean before = isEnabled();
            boolean after = !getMySelection().isEmpty();

            if (after != before) {
                setBaseEnabled(after);
            }
        }
    }
}