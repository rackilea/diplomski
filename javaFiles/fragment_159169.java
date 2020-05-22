@Provides
fun publisherListenerSet(
    @Named("car.listener") val carListener: PublisherListener,
    @Named("bike.listener") val bikeListener: PublisherListener
): Set<PublisherListener> { 
    setOf(carListener, bikeListener)
}