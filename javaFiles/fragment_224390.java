public void updateList(int positionInList, boolean likeState, boolean followedState, int numberOfComments, int numberOfViews) {
    eventsResponses.get(positionInList).setLiked(likeState);
    eventsResponses.get(positionInList).setFollowed(followedState);
    eventsResponses.get(positionInList).setComments(numberOfComments);
    eventsResponses.get(positionInList).setViews(numberOfViews);
    adapter.notifyDataSetChanged();
    Util.hideKeyboard(activity);
}