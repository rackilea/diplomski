document
    .select("th:has(a[title])")
    .forEach(e -> {
        System.out.println(e.text());
        System.out.println(((Element) e.nextSibling()).text());
    });