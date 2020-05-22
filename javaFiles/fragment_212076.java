void process(Node node)
{
            String name                     = node.getNodeName();
        Map<String, String> attributes      = XMLUtil.extractAttributes(node);

        // this is basically the current node, but we need to save it as
        // extra reference to copy all child elements from it, to further process
        // the document tree
        Node target = null;
        Node next   = null;
        Node parent = node.getParentNode();

        if(name.equals("text:" + TARGET_ELEMENT)) {
            // deep copy
            target = node.cloneNode(true);

            // create the three relevant bookmark nodes
            Node bkMrkStart = document.createElement("bookmark-begin");
            Node bkMrkEnd   = document.createElement("bookmark-end");
            Node bkMrkRsd   = document.createElement("bookmark");

            // insert bookmark start
            node.getParentNode().insertBefore(bkMrkStart, node);

            // get next sibling or null, if last elment
            next = node.getNextSibling();

            // insert ending bookmark and 'residue'
            parent.insertBefore(bkMrkRsd, next);
            parent.insertBefore(bkMrkEnd, bkMrkRsd);

            // create new its tag element
            AuxiliaryElement nextAux = createAuxiliary(attributes);


            // apply generated id to created bookmarks
            XMLUtil.setAttribute(
                    "text:span", 
                    "id-[" + nextAux.getId().getString() + "]", 
                    bkMrkStart, bkMrkEnd, bkMrkRsd);


            NodeList children = target.getChildNodes();

            int index = 0;
            do
            {
                Node child = children.item(index).cloneNode(true);
                // it seems necessary to extra save this element
                            // for further processing
                queue.add(child);

                parent.insertBefore(child, bkMrkEnd);
            } while(++index < children.getLength());

            // delete old element
            parent.removeChild(node);

            // clear target
            target = null;
        }
}