func ~= (lhs:Weapon, rhs:Weapon) -> Bool {
    return lhs == rhs
}

func test(sword:Weapon) {
    switch sword {
    case Weapon.STONE_SWORD:    print("stone")
    default:                    print("something else")
    }
}

test(Weapon.STONE_SWORD)