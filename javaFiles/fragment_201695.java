class SearchStrategies(val strategies: List<SearchStrategy>){
    fun findForConfig(config:Config) = strategies.find { it.javaClass.name.contains(config.agentStrategy) }
}


//somewhere at boot time
val searchStrategies = SearchStrategies(listOf(FastSearch(), AccurateSearch()))


//when needed
val config = ...
val agent = searchStrategies.findForConfig(config)