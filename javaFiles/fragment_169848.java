public static void main(final String[] args){

    // ... snip

    // change nr 1: use a generic declaration
    final Function<Fruit, Integer> fruitID =
        new Function<Fruit, Integer>(){

            @Override
            public Integer apply(final Fruit data){
                return data.id;
            }
        };

    // ... snip
}

public static <K, V> Map<K, V> mapValues(final List<V> values,

    // change nr. 2: use <? super V> instead of <V>
    final Function<? super V, K> function){

    // ... snip
}