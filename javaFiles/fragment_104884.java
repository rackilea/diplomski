print.melting_res <- function(x, ...) {

  cat(
    "The MELTING results are:\n\n",
    "  - Enthalpy: ", prettyNum(x$enthalpy_cal), " cal/mol",
    {if (!is.null(x$enthalpy_J)) paste0(" (", prettyNum(x$enthalpy_J), " J /mol)", collapse="") else ""}, "\n",
    "  - Entropy: ", prettyNum(x$entropy_cal), " cal/mol-K",
    {if (!is.null(x$entropy_J)) paste0(" (", prettyNum(x$entropy_J), " J /mol-K)", collapse="") else ""}, "\n",
    "  - Meltng temperature: ", prettyNum(x$melting_temp_C), " degress C\n",
    sep=""
  )

}