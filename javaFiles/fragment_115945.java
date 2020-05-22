BigDecimal sum = order.products()
     .stream()
     .flatMap(product -> product.getRestrictions()
                  .stream()
                  .filter(restriction -> restriction.equals(newProductRestriction))
                  .map(restriction -> product.getAmount().getNumberOfUnits()))
     .reduce(BigDecimal.ZERO, BigDecimal::add);
BigDecimal result = restrictionsNumber.add(sum);