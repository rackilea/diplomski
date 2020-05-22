if (registeredContactsList != null) {
    if (registeredContactsList.contains(email)) {
        Log.d(TAG, "Registered: " + email);
        viewHolder.tvRegistered.setText("Add to Friends");
    } 
    else {
        viewHolder.tvRegistered.setText("Invite");
    }
}