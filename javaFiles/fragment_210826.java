private boolean ignoreCheckEvent = false;

@Override
public void checkStateChanged(final CheckStateChangedEvent event) {
    if (ignoreCheckEvent)
        return;

    ignoreCheckEvent = true;

    try {
        // object checked
        final TreePath path = ((ITreeSelection) this.treeViewer.getSelection()).getPaths()[0];
        checkChildren(path, event.getChecked());
        checkParents(path.getParentPath());
        syncData();
    }
    finally {
        ignoreCheckEvent = false;
    }
}