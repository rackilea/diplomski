interface PackAnimal {
}

class Buffalo implements PackAnimal {
}

interface LonelyAnimal {
}

class Puma implements LonelyAnimal {
}

interface Pack<A extends PackAnimal> {
    // Obviously fine.
    List<A> getMembers();
}

// Raw type so no checking.
class PumaPack implements Pack {

    @Override
    public List<Puma> getMembers() {
        // Raw typed class so Puma isn't checked for PackAnimal super.
        return Arrays.asList(new Puma());
    }
}

class Six {

}

// Properly typed so Raw Types not happening.
class SixPack implements Pack<Six> {

    @Override
    // NOT ALLOWED: Attempt to use incompatible return type!!!
    public List<Six> getMembers() {
        return null;
    }
}