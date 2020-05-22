likeButton = (Button) convertView.findViewById(R.id.thought_like_button);
dislikeButton = (Button) convertView.findViewById(R.id.thought_dislike_button);

Thought t = thoughtItems.get(position);
if (t.hideButtons()) {
    likeButton.setVisibility(View.GONE);
    dislikeButton.setVisibility(View.GONE); 
}
else {
    likeButton.setVisibility(View.VISIBLE);
    dislikeButton.setVisibility(View.VISIBLE); 
}