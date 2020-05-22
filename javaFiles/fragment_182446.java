double levinWeight = Double.parseDouble(dataOnlyCombine[2]);
double lsmWeight = Double.parseDouble(dataOnlyCombine[3]);
double totalWeight = (levinWeight + 8 * lsmWeight) / 10.0;
// perform rounding only at the end as appropriate.

// to round to two decimal places 
double totalWeight2 = Math.round(totalWeight * 100) / 100.0;