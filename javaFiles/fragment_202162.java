static Optional<BigDecimal> sumImporto(List<DatiNegozio> datiNegozio) {

  return datiNegozio.stream() // Stream<DatiNegozio>
    .map(DatiNegozio::getNegozio)                 // Stream<List<Negozio>>

    // unroll stream of collections into a stream of collection elements
    .flatMap(List::stream)                        // Stream<Negozio>
    .map(Negozio::getTassazione)                  // Stream<List<Tassazione>>

    // again, unroll stream of collections into a stream of collection elements
    .flatMap(List::stream)
    .map(Tassazione::getImporto)                  // Stream<BigDecimal>

    // last thing we need to do is just reduce
    .reduce(BigDecimal::add);
  }