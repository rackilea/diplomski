Boolean changed = false;
float backR = 0.0f, backG = 0.0f, backB = 0.0f;
synchronized(mBackLock) {
    if (mBackChanged) {
        changed = true;
        backR = mBackRed;
        backG = mBackGreen;
        backB = mBackBlue;
        mBackChanged = false;
    }
}

if (changed) {
    glClearColor(backR, backG, backB, 0.0f);
}