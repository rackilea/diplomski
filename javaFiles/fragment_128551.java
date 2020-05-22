package com.stackoverflow.so22869350;

import com.google.common.collect.HashMultiset;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Multiset;

import java.util.Iterator;
import java.util.List;

public class Circular<T> {

    private final Multiset<T> counter;

    private final Iterator<T> elements;

    public Circular(final List<T> elements) {
        this.counter = HashMultiset.create();
        this.elements = Iterables.cycle(elements).iterator();
    }

    public T getOne() {
        final T element = this.elements.next();
        this.counter.add(element);
        return element;
    }

    public int getCount(final T element) {
        return this.counter.count(element);
    }

    public static void main(final String[] args) {
        final Circular<String> circular = new Circular<>(Lists.newArrayList("A", "B", "C"));
        for (int i = 0; i < 7; i++) {
            System.out.println(circular.getOne());
        }
        System.out.println("Count for A: " + circular.getCount("A"));
    }
}