Document document = Jsoup.parse(YOUT HTML GOES HERE);
    System.out.println(document);
    Elements elements = document.select("tr > th");

    for (Element element : elements) {
        String align = element.attr("align");
        String color = element.attr("bgcolor");
        String spanText = element.select("span").text();

        System.out.println("Align is " + align +
                "\nBackground Color is " + color +
                "\nSpan Text is " + spanText);
    }