if (!from_user.equals(fuser.getUid())) {
    Picasso.with(viewHolder.profileImage.getContext()).load(image).placeholder(R.drawable.default_avatar).into(viewHolder.profileImage);
} else {
    // Load the default avatar when the above condition fails.
    Picasso.with(viewHolder.profileImage.getContext()).load(R.drawable.default_avatar).into(viewHolder.profileImage);
}