calculMethod <- results$getCalculMethod()

enthalpy <- results$getEnthalpy()
entropy <- results$getEntropy()

if (.jinstanceof(calculMethod, J("melting.nearestNeighborModel.NearestNeighborMode"))) {
  enthalpy <- results$getEnergyValueInJ(enthalpy)
  entropy <- results$getEnergyValueInJ(entropy)
}

melting_temperature <- results$getTm()

enthalpy
## [1] -1705440

entropy
## [1] -4566.232

melting_temperature
## [1] 72.04301