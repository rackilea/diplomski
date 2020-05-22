public int getGoodCount() {
    int count = 0;
    for (User u : this.userList) {
        if (u.result.equals("good")) count += 1;
    }
    return count;
}

// Assuming there is only good and bad
public int getBadCount() {
    return getItemCount() - getGoodCount();
}