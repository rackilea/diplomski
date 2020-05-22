final AtomicInteger present = map.get(tag);
int count; 

if (present != null) {

    count = present.incrementAndGet(); 

} else {

    final AtomicInteger instance = new AtomicInteger(0);
    final AtomicInteger marker = map.putIfAbsent(tag, instance);

    if (marker == null) {

        count = instance.incrementAndGet();

    } else {

        count = marker.incrementAndGet();
    }
}