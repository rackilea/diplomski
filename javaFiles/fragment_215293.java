conditionalLock();
    try {
        // block you want to synchronize between threads of group A & B
    } finally {
        conditionalUnlock();
    }