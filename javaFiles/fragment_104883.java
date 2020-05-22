get_melting_results <- function(opts = c()) {

  stopifnot(length(opts) > 2) # a sanity check that could be improved

  Sys.setenv("NN_PATH"=system.file("extdata", "Data", package="melting5jars"))

  require(melting5jars)

  melting <- new(J("melting.Main"))
  optionManager <- new(J("melting.configuration.OptionManagement"))

  results <- melting$getMeltingResults(opts, optionManager)

  calculMethod <- results$getCalculMethod()

  enthalpy_cal <- results$getEnthalpy()
  entropy_cal <- results$getEntropy()

  enthalpy_J <- entropy_J <- NULL

  if (.jinstanceof(calculMethod, J("melting.nearestNeighborModel.NearestNeighborMode"))) {
    enthalpy_J <- results$getEnergyValueInJ(enthalpy_cal)
    entropy_J <- results$getEnergyValueInJ(entropy_cal)
  }

  melting_temp_C <- results$getTm()

  list(
    enthalpy_cal = enthalpy_cal,
    entropy_cal = entropy_cal,
    enthalpy_J = enthalpy_J,
    entropy_J = entropy_J,
    melting_temp_C = melting_temp_C
  ) -> out

  class(out) <- c("melting_res")

  out

}