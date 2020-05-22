private static final Namespace findFirst(List<Namespace> namespaces, String uri) {
    for (Namespace ns : namespaces) {
        if (ns.getURI().equals(uri)) {
            return ns;
        }
    }
    return null;
}


public static final void dedupElementNamespaces(Element node) {
    List<Namespace> created = node.getNamespacesIntroduced();
    if (!created.isEmpty()) {
        // check anything new against other stuff...
        List<Namespace> inherited = node.getNamespacesInherited();
        // check out element against previous declarations....
        if (node.getNamespace().getPrefix() != "") {
            // never swap defaulted namespaces to anything with a prefix.
            Namespace ens = node.getNamespace();
            Namespace use = findFirst(inherited, node.getNamespaceURI());
            if (use != null && use != ens) {
                node.setNamespace(use);
            }
        }           

    }
    for (Element e : node.getChildren()) {
        dedupElementNamespaces(e);
    }
}