public String extractName(Element building) {
     return this.selectors
             .getName()
             .map(cssSelector -> {
                        Elements buildingNameElement = building.select(cssSelector);
                        return buildingNameElement.text();
                    })
             .orElse("N/A");
}