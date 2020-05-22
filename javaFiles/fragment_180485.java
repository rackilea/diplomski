public int getInt() {
    int i;
    if (CFLib.INSTANCE.CFNumberGetValue(this, kCFNumberSInt32Type, (IntPtr)i))
        return i;
    return -1;
}