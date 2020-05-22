package com.test;

import java.util.Map;

public class ProposalAggregation {

private Map<String, Map<String, String>> Buys;
private Map<String, Map<String, String>> Sells;
private Map<String, Map<String, String>> TAChanges;

public Map<String, Map<String, String>> getBuys() {
    return Buys;
}

public void setBuys(Map<String, Map<String, String>> buys) {
    Buys = buys;
}

public Map<String, Map<String, String>> getSells() {
    return Sells;
}

public void setSells(Map<String, Map<String, String>> sells) {
    Sells = sells;
}

public Map<String, Map<String, String>> getTAChanges() {
    return TAChanges;
}

public void setTAChanges(Map<String, Map<String, String>> tAChanges) {
    TAChanges = tAChanges;
}

public String toString() {
    return "BUYS=" + this.Buys + " \nSELLS=" + this.Sells + " \nTACHANGES="
            + this.TAChanges;
}