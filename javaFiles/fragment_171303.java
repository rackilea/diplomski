public struct Weapon {
    public let name : String
    public let damage : Int

    private init(name:String, damage:Int) {
        self.name = name
        self.damage = damage
    }

    public static let WOODEN_SWORD = Weapon(name: "Wooden Sword", damage: 4)
    public static let STONE_SWORD = Weapon(name: "Stone Sword", damage: 6)
    public static let STEEL_SWORD = Weapon(name: "Steel Sword", damage: 8)
}