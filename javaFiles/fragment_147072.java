Elements textElements = document.select("h1, p");

for (Element e : textElements.select("*")) {
    for (TextNode tn : e.textNodes()) {
        tn.text(tn.text().toUpperCase());
    }
}