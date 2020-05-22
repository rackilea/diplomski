public static void main(String args[]) {
        Supplier<Cat> lolCatSupplier = LolCat::new;
        Supplier<Cat> fatCatSupplier = FatCat::new;
        Cat lolCat = lolCatSupplier.get();
        Cat fatCat = fatCatSupplier.get();
        System.out.println(lolCat.getClass());
        System.out.println(fatCat.getClass());
    }