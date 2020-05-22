if (entry.getKey().contains(".")) {

        int dotIndex = entry.getKey().indexOf(".");
        String parentTag = entry.getKey().substring(0, dotIndex);
        String childTag = entry.getKey().substring(dotIndex + 1, entry.getKey().length());
        pchild = new Element(parentTag);
        pchild.addContent(new Element(childTag).setText(entry.getValue()));
        root.addContent(pchild);

    }