public void setDisabled(final boolean disabled) {
    toggleFlag(B1, disabled);
}

private void toggleFlag(final int bit, final boolean on) {
    if (on)
        this._rflags |= 1 << bit;
    else
        this._rflags &= ~(1 << bit);
}