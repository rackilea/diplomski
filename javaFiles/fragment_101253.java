parsedJson.aprLimits.inject(
    [:].withDefault{[]} // if a key is missing, add it and make the value an empty vector
){ r, v -> 
    r[v.orgId] << [v.rangeStart, v.rangeEnd, v.amountLimit]
    r
}