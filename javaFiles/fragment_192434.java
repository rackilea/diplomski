Document doc = getDocumen("https://pl.wiktionary.org/wiki/set#set_.28j.C4.99zyk_angielski.29");
Elements elements = doc.select("h2:has(span#en) ~ p:not(h2:has(span#en) ~ p ~ h2 ~ p) i, h2:has(span#en) ~ p:not(h2:has(span#en) ~ p ~ h2 ~ p) + dl > dd");
if (elements.isEmpty()) {
    throw new RuntimeException("No definitions found.");
}

String parent = null;
for (Element element : elements) {
    switch (element.tagName().toLowerCase()) {
    case "i":
        parent = element.text();
        break;

    case "dd":
        System.out.println(parent + " - " + element.text());
        break;

    default:
        throw new RuntimeException("Unexpected element:\n" + element.outerHtml());
    }
}