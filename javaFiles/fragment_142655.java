person shortest = null;
for (person p : People) {
    if (shortest == null || p.getHeight() < shortest.getHeight()) {
        shortest = p;
    }
}

String s = shortest.toString();