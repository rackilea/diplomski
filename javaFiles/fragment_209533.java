HeaderPart headerPart = new HeaderPart(new PartName("/word/header"+ (countHeader++) +".xml"));
headerPart.setPackage(wordprocessingMLPackage);
headerPart.setRelationshipType(Namespaces.HEADER);
headerPart.setJaxbElement(objectFactory.createHdr());
Relationship relationship = documentPart.addTargetPart(headerPart);
HeaderReference headerReference = objectFactory.createHeaderReference();
headerReference.setId(relationship.getId());
headerReference.setType(HdrFtrRef.DEFAULT);
sectPr.getEGHdrFtrReferences().add(headerReference);