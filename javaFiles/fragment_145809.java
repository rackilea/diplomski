Document doc = Jsoup.parse(html);
        for (Element e : doc.select("span")) {

            Element parent = e.parent();
            Element newParent = parent.clone();
            newParent.empty();
            for (Node n : parent.childNodes()) {

                if (n instanceof Element && ((Element) n).tag().getName().equals("span")) {
                    newParent.append(((Element) n).html());
                } else {
                    newParent.append(n.outerHtml());
                }

            }
            parent.replaceWith(newParent);

        }