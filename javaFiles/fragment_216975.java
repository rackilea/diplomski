if (position != RecyclerView.NO_POSITION) {
    Contact contact = contactList.get(position);
    //Toast.makeText(v.getContext(), "You clicked " + holder.contactId + ", number of selected contacts is " + getSelectedItemCount() + ", contacts id's are " + getSelectedUserIds(holder.contactId = contact.getUserId(), position), Toast.LENGTH_SHORT).show();
    applyIconAnimation(holder, position);
    String userId = contact.getUserId();

    // Adding/removing user ids to list
    if (!selectedIds.contains(userId)) {
        selectedIds.add(userId);
    } else {
        selectedIds.remove(userId);
    }
}