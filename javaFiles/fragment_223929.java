BlipFinder bf = new BlipFinder();
    new TraversalUtil(paragraphs, bf);

    for (CTBlip imageReference : bf.blips) {

        if (imageReference.getLink() != null
                && !imageReference.getLink().equals("")) {

            Relationship existingRel = docxPkg.getMainDocumentPart()
                    .getRelationshipsPart().getRelationshipByID(
                            imageReference.getLink());

            :

        } else if (imageReference.getEmbed() != null) {

            String relId = imageReference.getEmbed();

            Relationship r = docxPkg.getMainDocumentPart().getRelationshipsPart().getRelationshipByID(relId);
            if (r.getTargetMode()!=null 
                    && r.getTargetMode().toLowerCase().equals("external")) {
                :

            } else {

                BinaryPartAbstractImage oldPart = (BinaryPartAbstractImage)docxPkg.getMainDocumentPart().getRelationshipsPart().getPart(relId);

                : 

            }

        } else {
            log.error("HELP! neither linked nor embedded?");
        }

    }
}

    static class BlipFinder extends CallbackImpl {

        List<CTBlip> blips = new ArrayList<CTBlip>();  

        @Override
        public List<Object> apply(Object o) {

            if (o instanceof CTBlip)
                blips.add((CTBlip)o);

            return null;
        }