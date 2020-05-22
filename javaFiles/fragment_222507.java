package com.google.gson.graph;

/**
 * @author Giacomo Tesio
 */
public interface GenericFunction<Domain, Codomain> {
    Codomain map(Domain domain);
}