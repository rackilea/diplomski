package org.example.ronvisbord.solr.queries.custom;

import org.apache.lucene.search.Query;

public class HeightFunctionQuery extends Query {

    private final String queryTemplate = "(_val_:\"%s\")^%f";
    private final String functionTemplate = "div(1,abs(sub(%s,%d)))";
    private double boost;

    @Override
    public String toString(String field) {
        return String.format(queryTemplate, createFunction(field), boost);
    }

    public HeightFunctionQuery(double boost, int targetHeight) {
        this.boost = boost;
        this.targetHeight = targetHeight;
    }

    private String createFunction(String field) {
        return String.format(functionTemplate, field, targetHeight);
    }
}