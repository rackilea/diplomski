import java.util.*;

public final class ClientOrderEquality {
    private ClientOrderEquality() {}

    private static final class Counter { long value; }

    public static boolean equals(Client lhs, Client rhs) {
        return equals(lhs, new IdentityHashMap<>(),
                      rhs, new IdentityHashMap<>(),
                      new Counter());
    }

    public static boolean equals(Order lhs, Order rhs) {
        return equals(lhs, new IdentityHashMap<>(),
                      rhs, new IdentityHashMap<>(),
                      new Counter());
    }

    private static boolean equals(Client            lhs,
                                  Map<Object, Long> seenL,
                                  Client            rhs,
                                  Map<Object, Long> seenR,
                                  Counter           counter) {
        if (lhs == null || rhs == null)
            return lhs == rhs;
        Long countL = seenL.putIfAbsent(lhs, counter.value);
        Long countR = seenR.putIfAbsent(rhs, counter.value);
        if (countL != null || countR != null)
            return Objects.equals(countL, countR);
        counter.value++;
        if (lhs == rhs)
            return true;
        if (!Objects.equals(lhs.id, rhs.id))
            return false;
        if (!Objects.equals(lhs.name, rhs.name))
            return false;
        if (lhs.orders.size() != rhs.orders.size())
            return false;
        Iterator<Order> itL = lhs.orders.iterator();
        Iterator<Order> itR = rhs.orders.iterator();
        while (itL.hasNext() && itR.hasNext())
            if (!equals(itL.next(), seenL, itR.next(), seenR, counter))
                return false;
        return true;
    }

    private static boolean equals(Order             lhs,
                                  Map<Object, Long> seenL,
                                  Order             rhs,
                                  Map<Object, Long> seenR,
                                  Counter           counter) {
        if (lhs == null || rhs == null)
            return lhs == rhs;
        Long countL = seenL.putIfAbsent(lhs, counter.value);
        Long countR = seenR.putIfAbsent(rhs, counter.value);
        if (countL != null || countR != null)
            return Objects.equals(countL, countR);
        counter.value++;
        if (lhs == rhs)
            return true;
        if (!Objects.equals(lhs.id, rhs.id))
            return false;
        if (!Objects.equals(lhs.name, rhs.name))
            return false;
        return equals(lhs.client, seenL, rhs.client, seenR, counter);
    }
}