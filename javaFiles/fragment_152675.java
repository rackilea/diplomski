package com.sel2in.sort;

import java.util.Map.Entry;

public class TEntry<K,V> implements Entry<K, V> {
    final K key;
    V value;

    TEntry(){
        key = null;
    }

    TEntry(K k){
        key = k;
    }    

    TEntry(K k, V v) {
        value = v;
        key = k;
    }    



    @Override
    public K getKey() {
        return key;
    }

    @Override
    public V getValue() {
        return value;
    }

    @Override
    public V setValue(V newValue) {
        V oldValue = value;
        value = newValue;
        return oldValue;
    }

    public String toString(){
        return key + ":" + value;
    }

    //can copy hashcode , equals but not important now

}