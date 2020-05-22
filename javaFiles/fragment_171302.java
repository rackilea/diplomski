public enum Weapon : Int {
    case WOODEN_SWORD = 4
    case STONE_SWORD = 6
    case STEEL_SWORD = 8

    func getDamage() -> Int {
        return rawValue
    }

    func getName() -> String {
        switch self {
        case .WOODEN_SWORD: return "Wooden Sword"
        case .STONE_SWORD:  return "Stone Sword"
        case .STEEL_SWORD:  return "Steel Sword"
        }
    }
}