private void updateEventInList(boolean likeState, boolean followedState, int comments, int viewsNr, ViewHolder views) {
    if (parentFragment != null && parentFragment instanceof EventListFragment) {
        Log.i(TAG, "Position in list : " + positionInList + "\nlike / follow states : " + likeState + "/" + followedState + "\ncomments number : " + comments + "\nviews number : " + viewsNr);
        ((EventListFragment) parentFragment).updateList(positionInList, likeState, followedState, comments, viewsNr);
    }
}