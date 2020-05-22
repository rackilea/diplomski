public Cable getCable() {
    if (dstPortCable != null) {
        return dstPortCable;
    }
    if (srcPortCable != null) {
        return srcPortCable;
    }
    return null;
}