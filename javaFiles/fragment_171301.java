public enum EnumWeapon {
    case WOODEN_SWORD
    case STONE_SWORD
    case STEEL_SWORD

    func getName() -> String {
        switch self {
        case WOODEN_SWORD:  return "Wooden Sword"
        case STONE_SWORD:   return "Stone Sword"
        case STEEL_SWORD:   return "Steel Sword"
        }
    }

    func getDamage() -> Int {
        switch self {
        case WOODEN_SWORD:  return 4
        case STONE_SWORD:   return 6
        case STEEL_SWORD:   return 8
        }
    }
}