int parameterIndex = 1;
// Note: more idiomatic to declare the iteration variable
// inside the loop
for (int headerIndex = 0; headerIndex < headers.length; headerIndex++) {
    String header = headers[headerIndex];
    if (headerIndex == groupBy) {
        parameters.put("Parameter_GroupBy", header);
    } else {
        parameters.put("Parameter_" + parameterIndex, header);
        parameterIndex++;
    }
}