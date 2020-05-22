long slotID = config.getSlotID();
    // ....
        if ((slotID < 0) || showInfo) {
            long[] slots = p11.C_GetSlotList(false);
            if (showInfo) {
                System.out.println("All slots: " + toString(slots));
                slots = p11.C_GetSlotList(true);
                System.out.println("Slots with tokens: " + toString(slots));
            }
            if (slotID < 0) {
                if ((slotListIndex < 0) || (slotListIndex >= slots.length)) {
                    throw new ProviderException("slotListIndex is " + slotListIndex
                        + " but token only has " + slots.length + " slots");
                }
                slotID = slots[slotListIndex];
            }
        }
        this.slotID = slotID;