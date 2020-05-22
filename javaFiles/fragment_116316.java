public static boolean hasLoops(final A a)
{
    if (a.a2 == null)
         return false;
    final Set<A> set = new IdentityHashSet<>();
    set.add(a.a2);
    A other = a.a1;
    while (other != null) {
        if (!set.add(other))
            return true;
        other = other.a1;
   }
   return false;
}