...

    companion object {
        val MANDATORY_PARAMS = listOf("bookingReference", "lastName")
        fun mandatoryParametersHaveBeenProvided(params: Map<String, String>) : Boolean {
            return params.keys.containsAll(MANDATORY_PARAMS)
        }
    }
}