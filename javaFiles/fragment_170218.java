public static long getTimeSlotAvailable(Long location) {
    List<Pending_Inventory> pendingItems = getPendingItems(location, true);
    int numSlots = Slot.getUnlockedSlots(location);

    // Add all of the times a slot will become available to a list
    List<Long> finishTimes = new ArrayList<>();
    for (Pending_Inventory pending_inventory : pendingItems) {
        long finishTime = pending_inventory.getTimeCreated() + pending_inventory.getCraftTime();
         finishTimes.add(finishTime);
    }

    // Sort these times so the latest time is first
    Collections.sort(finishTimes, Collections.<Long>reverseOrder());

    if (finishTimes.size() >= numSlots) {
        // If we're all full up, get the first time a slot will become available
        return finishTimes.get(numSlots-1);
    } else {
        // Otherwise, it can go in now
        return System.currentTimeMillis();
    }
}