public void pet1Init(){
    pet1 = getPet().get();
}

public void pet2Init(){
    pet2 = getPet().get();
}

private Supplier<Pet> getPet() {
    Supplier<Pet> supplier = Cat::new; // default pet

    switch (i){
        case 0:
            supplier = Cat::new;
            break;
        case 1:
            supplier = Dog::new;
            break;
    }

    return supplier;
}