public int getItemViewType(int position) {
        final ParseObject notifications = mNotifications.get(position);
        if (notifications.getString("notificationType").equals("typeLike")) {
            return LIKE;
        } else {
            return COMMENT;
        }
    }