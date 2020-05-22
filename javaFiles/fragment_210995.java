return links.stream()
            .filter(d -> StringUtils.equalsIgnoreCase(d.getRel(), "Self"))
            .findFirst() // returns an Optional<Links>
            .map(Links::getHref) // returns an Optional<String>
            .orElse(null); // returns String (either getHref of the found Links instance, or
                           // null if no instance passed the filter)