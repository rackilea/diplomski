public void setFlags(int flags, int mask) {
    final WindowManager.LayoutParams attrs = getAttributes();
    attrs.flags = (attrs.flags&~mask) | (flags&mask);
    mForcedWindowFlags |= mask;
    dispatchWindowAttributesChanged(attrs);
}