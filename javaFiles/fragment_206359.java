if(message_type.equals("text")) {
    // You need to set the visibility of the message image here as well
    viewHolder.messageImage.setVisibility(View.GONE);
    viewHolder.messageText.setText(c.getMessage());
} else {
    viewHolder.messageImage.setVisibility(View.VISIBLE);
    Picasso.with(viewHolder.messageImage.getContext()).load(c.getMessage()).placeholder(R.drawable.default_avatar).into(viewHolder.messageImage);
}