LispList<Integer> positions (final int item, final LispList<Integer> list) {
    if (list.isEmpty()) {
        return new LispList<Integer>();
    }
    final LispList<Integer> tailResult = positions( item, list.tail() );
    final LispList<Integer> result = tailResult.addToEach( 1 );
    if (list.head().intValue() == item) {
        return result.cons( 0 );
    } else {
        return result;
    }
}