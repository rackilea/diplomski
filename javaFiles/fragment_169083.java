if (entry.getKey().contains(".")) {

        int dotIndex = entry.getKey().indexOf(".");
        String parentTag = entry.getKey().substring(0, dotIndex);
        String childTag = entry.getKey().substring(dotIndex + 1, entry.getKey().length());

        // locate the previously created `logger` element, if any.
        pchild = root.getChild(parentTag);
        if (pchild == null) {

            // need to add the child if it did not exist.
            pchild = new Element(parentTag);
            root.addContent(pchild);
        }
        pchild.addContent(new Element(childTag).setText(entry.getValue()));

    }