for (Element element : elements) {

    if (element.text().contentEquals("See also") || element.text().contentEquals("References") || element.text().contentEquals("Bibliography") || element.text().contentEquals("External links") || element.text().contentEquals("Bibliography"))
        continue;

    else
        // This will get the element immediately before the current one.
        System.out.print(element.previousElementSibling().text() + " ");
        System.out.println(element.ownText());
}