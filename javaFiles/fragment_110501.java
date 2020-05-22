Elements divs = document.select("div");
Elements innerMostDivs = new Elements();

for (Element div : divs) {
    if (div.select(">div").isEmpty()) {
        innerMostDivs.add(div);
    }
}

// ...