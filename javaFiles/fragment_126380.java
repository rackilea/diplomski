switch ((x + 1) | ((y + 1) << 4) | ((z + 1) << 8)) {
    case 0x110: return Direction.X_LEFT;  // x == -1, y ==  0, z ==  0
    case 0x112: return Direction.X_RIGHT; // x ==  1, y ==  0, z ==  0
    case 0x101: return Direction.DOWN;    // x ==  0, y == -1, z ==  0
    case 0x121: return Direction.TOP;     // x ==  0, y ==  1, z ==  0
    case 0x011: return Direction.Z_LEFT;  // x ==  0, y ==  0, z == -1
    case 0x211: return Direction.Z_RIGHT; // x ==  0, y ==  0, z ==  1
    default:    return null;              // other invalid combination
}