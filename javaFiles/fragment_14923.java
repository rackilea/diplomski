class Factory {

    Pet newPetOfType(PetType type) {
        switch (type) {
            case CAT: return new Cat();
            ...
        }
    }

    @Configurable
    private static class Cat extends Pet {
        @Autowired private Prop prop;
        ...
    }
}