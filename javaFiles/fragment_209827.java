StringBuilder sb = new StringBuilder();
String queryString;

queryString = myQuery.get(array[0]);
if(queryString != null) {
    sb.append(queryString);
}

// now skip the first entry, proceed the rest
for(int i=1; i<array.length; i++) {
    sb.append(" union all "); // If you want to build a query, watch the whitespaces
    sb.append(queryString);
}