} else if (line.startsWith("go ")) {
    String dir = line.substring(3);
    Room next = current.getNextRoom(dir);
    if (next == null) {
        System.out.println("You cannot go " + dir + " from here.");
    } else {
        if (next.isLocked() && inventory.contains(next.requiredKey())) {
            current = next;
            System.out.println("You use the " + next.requiredKey() + " to unlock the next room...");
            current.describe();
        } else if (next.isLocked()) {
            System.out.println("That room is locked and you don't have the required key");
        } else {
            current = next;
            current.describe();
        }
    }
} else if (line.startsWith("take ")) {