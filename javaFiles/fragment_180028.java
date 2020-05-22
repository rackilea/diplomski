synchronized (mAction) {
    for(Iterator<IStartAction> iter = mActions.iterator(); iter.hashNext();) {
        IStartAction action = iter.next();
        if (!action.isApplicable()) {
            iter.remove();
        }
    }
}