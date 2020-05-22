String url = element.attr(absoluteRef);

    if(url!=null && url.trim().length()>0 
                 && url.matches("[http].+[^(pdf|rar|zip)]")) {
        LinkNode link = new LinkNode(url);
        link.setTag(element.tagName());
        link.setParentLink(parentLink);
        links.add(link);
    }