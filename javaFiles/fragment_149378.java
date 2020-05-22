for (int dock = 0; dock < dockCount; dock++) {
    for (int berth = 0; berth < berthCount; berth++) {
        int size = (int)Math.floor(Math.random() * 3 + 1);
        docks[dock][berth] = size;
    }
}