Optional<BigDecimal> max = brol.stream()
                               .map(a -> a.amount)
                               .max(Comparator.naturalOrder());
if (max.isPresent()) {
   // have a max
}