assertEquals(0, getActiveDirectBuffers(alloc));
assertEquals(0, getActiveHeapBuffers(alloc));

int getActiveDirectBuffers(PooledByteBufAllocator alloc) {
    int directActive = 0, directAlloc = 0, directDealloc = 0;
    for (PoolArenaMetric arena : alloc.directArenas()) {
        directActive += arena.numActiveAllocations();
        directAlloc += arena.numAllocations();
        directDealloc += arena.numDeallocations();
    }
    System.out.println("directActive " + directActive + " directAlloc " + directAlloc + " directDealloc " + directDealloc);
    return directActive;
}

int getActiveHeapBuffers(PooledByteBufAllocator alloc) {
    int heapActive = 0, heapAlloc = 0, heapDealloc = 0;
    for (PoolArenaMetric arena : alloc.heapArenas()) {
        heapActive += arena.numActiveAllocations();
        heapAlloc += arena.numAllocations();
        heapDealloc += arena.numDeallocations();
    }
    System.out.println("heapActive " + heapActive + " heapAlloc " + heapAlloc + " heapDealloc " + heapDealloc);
    return heapActive;
}