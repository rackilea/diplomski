LispList<Integer> positions (final int item, final LispList<Integer> list) {
    return positionsAux( item, list, 0, new LispList<Integer>() );
}

private LispList<Integer> positionsAux (final int item,
                                        final LispList<Integer> list,
                                        final int position,
                                        final LispList<Integer> result) {
    if (list.isEmpty()) {
        return result.reverse();
    }
    if (list.head().intValue() == item) {
        result = result.cons(position);
    }
    return positionsAux( item, list.tail(), position + 1, result );
}