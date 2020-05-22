public class Tmp {
    public static void main(String[] args) throws ReflectiveOperationException {
        MethodHandles.Lookup lookup = MethodHandles.lookup();
        MethodHandle mh = lookup
          .findStatic(Tmp.class, "main", MethodType.methodType(void.class, String[].class));
        Method method = lookup.revealDirect(mh).reflectAs(Method.class, lookup);
        System.out.println(method);
    }
}