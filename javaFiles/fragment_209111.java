Double[] outputs = new Double[3];
outputs[0] = temp1 + (temp2 / 2) - Math.sqrt( (Cvalue_0 * Cvalue_0) - (Avalue_0 * Avalue_0) );
outputs[1] = temp1 + (temp2 / 2) - Math.sqrt( (Cvalue_1 * Cvalue_1) - (Avalue_1 * Avalue_1) );
outputs[2] = temp1 + (temp2 / 2) - Math.sqrt( (Cvalue_2 * Cvalue_2) - (Avalue_2 * Avalue_2) );

Arrays.sort(outputs);
// Now outputs[2] will have the highest value. Use it however you please.