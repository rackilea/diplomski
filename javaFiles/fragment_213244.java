// At preparation time
Arrays.sort(names, String.CASE_INSENSITIVE_ORDER);
...
// At query time
int pos = Arrays.binarySearch(names, query, String.CASE_INSENSITIVE_ORDER);
if (pos < 0) {
    pos = -(pos+1);
}
while (pos < names.length) {
    if (names[pos].toLowerCase().startsWith(query.toLowerCase())) {
        c.addRow(new Object[]{pos, names[pos]});
        pos++;
    } else {
        break;
    }
}