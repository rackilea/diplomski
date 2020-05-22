int dock, berth, size;
for (size = boatSize; size <= 3; size++) {
    boolean found = false;
    for (dock = 0; dock < dockCount; dock++) {
        for (berth = 0; berth < berthCount; berth++) {
            if (!full[dock][berth]) {
                if (size == docks[dock][berth]) {
                    found = full[dock][berth] = true;
                    break;
                }
            }
        }
        if (found) break;
    }
    if (found) break;
}

if (size > 3) {
    System.out.println("No vacancy");
} else {
    System.out.println("Take the " + sizes[size]
        + " berth at dock " + (dock+1) + " space " + (space+1));
}