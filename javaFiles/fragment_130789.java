public static Map<String, PDPageDestination> getAllNamedDestinations(PDDocument document){

        Map<String, PDPageDestination> namedDestinations = new HashMap<>(10);

        // get catalog
        PDDocumentCatalog documentCatalog = document.getDocumentCatalog();

        PDDocumentNameDictionary names = documentCatalog.getNames();

        if(names == null)
            return namedDestinations;

        PDDestinationNameTreeNode dests = names.getDests();

        try {
            if (dests.getNames() != null)
                namedDestinations.putAll(dests.getNames());
        } catch (Exception e){ e.printStackTrace(); }

        List<PDNameTreeNode<PDPageDestination>> kids = dests.getKids();

        traverseKids(kids, namedDestinations);

        return namedDestinations;
    }

private static void traverseKids(List<PDNameTreeNode<PDPageDestination>> kids, Map<String, PDPageDestination> namedDestinations){

    if(kids == null)
        return;

    try {
        for(PDNameTreeNode<PDPageDestination> kid : kids){
            if(kid.getNames() != null){
                try {
                    namedDestinations.putAll(kid.getNames());
                } catch (Exception e){ System.out.println("INFO: Duplicate named destinations in document."); e.printStackTrace(); }
            }

            if (kid.getKids() != null)
                traverseKids(kid.getKids(), namedDestinations);
        }

    } catch (Exception e){
        e.printStackTrace();
    }
}