private Optional<FinalEntity> doLogic(String inputCountry, String inputType, Integer inputQuantity, Integer inputTax) {
    return Stream.of(new Inventory(new Product("cola", 15), "germany", 1000))
            .filter(inv -> inv.getProduct().getType().equals(inputType) && inv.getQuantity() > inputQuantity)
            .peek(inv -> {
                Integer tax = inv.getCountry().equals(inputCountry) ? 0 : inputTax;
                inv.setTotalPrice((inv.getProduct().getPrice() * inputQuantity) + tax);
            })
            .sorted(Comparator.comparing(Inventory::getTotalPrice))
            .findFirst()
            .map(Util::mapToFinalEntity);
}