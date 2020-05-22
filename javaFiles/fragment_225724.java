public int compareTo(IsoSprite o) {
    // Comparison A
    if (o.maxX > minX && o.maxY > minY && o.minZ < maxZ) {
        return -1;
    // Comparison B
    } else if (o.maxX > minX && o.maxY > minY && o.minZ > maxZ) {
        return 1;
    // Comparison C
    }else if (o.maxX < minX && o.maxY > minY && o.minZ > maxZ) {
        return 1;
    // Comparison D
    }else if (o.maxX < minX && o.maxY < minY && o.minZ > maxZ) {
        return 1;
    // Comparison E
    }else if (o.maxX < minX && o.maxY > minY && o.minZ < maxZ) {
        return 1;
    // Comparison F
    }else if (o.maxX > minX && o.maxY < minY && o.minZ > maxZ) {
        return 1;
    // Comparison G
    }else if (o.maxX < minX && o.maxY < minY && o.minZ > maxZ) {
        return 1;
    // Comparison H
    }else if (o.maxX > minX && o.maxY < minY && o.minZ < maxZ) {
        return 1;
    // Comparison I
    }else if (o.maxX < minX && o.maxY > minY && o.minZ < maxZ) {
        return 1;
    // Comparison J
    }else if(this != o){
        return 1;
    }
    return 0;
}