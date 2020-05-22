myMap = Maps.newHashMap(new ImmutableMap.Builder<K, V>()
                   .put(k1, v1) //One k-v pair 
                   .putAll(otherMap) //From other Map
                   .put(Maps.immutableEntry(k2, v3)) //From a Map Entry
                   ...
                   .build());