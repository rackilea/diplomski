package com.ic.utils;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;

/**
 * Prints different system variables
 * @author MockerTim
 */
public class EnvFinder {
    /**
     * Prints environment variables
     */
    public void listSystemEnv() {
        System.out.println("\nSystem Environment Variables:\n");
        Map<String,String> map = System.getenv();
        Set<Entry<String,String>> entrys = map.entrySet();

        Entry<String,String>[] a = sortSystemEnv(entrys);
        for (int i = 0; i < a.length; i++) {
            Entry<String, String> entry = a[i];
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }

    private Entry<String,String>[] sortSystemEnv(Set<Entry<String,String>> set) {
        Entry<String,String>[] a = new Entry[set.size()];
        set.toArray(a);

        Arrays.sort(a, new Comparator<Entry<String,String>>() {

            @Override
            public int compare(Entry<String, String> o1, Entry<String, String> o2) {
                return o1.getKey().compareToIgnoreCase(o2.getKey());
            }
        });

        return a;
    }

    /**
     * Prints java system properties
     */
    public void listJavaSystemProperties() {
        System.out.println("\nJava System Properties:\n");
        Properties sysProp = System.getProperties();

        Set<String> keys = sysProp.stringPropertyNames();
        Pair<String,String>[] pairs = new Pair[keys.size()];
        int i = 0;
        for (String string : keys) {
            pairs[i++] = new Pair<String,String>(string, sysProp.getProperty(string));
        }

        Arrays.sort(pairs, new Comparator<Pair<String,String>> () {

            @Override
            public int compare(Pair<String, String> o1, Pair<String, String> o2) {
                return o1.getFirst().compareToIgnoreCase(o2.getFirst());
            }
        });

        for (int j = 0; j < pairs.length; j++) {
            Pair<String, String> pair = pairs[j];
            System.out.println(pair.getFirst() + " : " + pair.getSecond());
        }
    }

    public static void main(String[] args) {
        EnvFinder instance = new EnvFinder();
        instance.listJavaSystemProperties();
        instance.listSystemEnv();
    }
}

/**
 * Support class for EnvFinder.class
 * @author tss
 * @param <T0>
 * @param <T1>
 */
class Pair<T0, T1> {

    public Pair (T0 t0, T1 t1) {
        first = t0;
        second = t1;
    }

    public T0 getFirst() {
        return first;
    }

    public T1 getSecond() {
        return second;
    }

    private T0 first;
    private T1 second;
}