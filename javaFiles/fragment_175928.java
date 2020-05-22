public static void main(String[] args) {

    String demo = "<td class='detail' id='ar-content-html'><div style='float:right; padding: 10px'></div><p>&nbsp;</p>foo<div style='padding: 20px'>bar</div></td>";

    Document document = Jsoup.parse(demo);
    Element options = document.select("div").first();

    Elements siblings = options.siblingElements();

    List<Element> sibling = siblings.subList(1, siblings.size());

    Iterator<Element> sibIterator = sibling.iterator();

    while (sibIterator.hasNext()) {
        System.out.println(sibIterator.next().toString());
    }

}