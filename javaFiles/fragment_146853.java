private static Product createByString(String name) {
     try {
         return Class.forName("your.pkgname. " + name).asSubclass(Product.class).getConstructor().newInstance();
     } catch (ReflectiveOperationException e) {
         throw new RuntimeException(e);
     }
}