@Override
public Future<E> submit(E e) {
    return itemsBeingWorkedOn.compute(e, (k, v) -> {
        if (v == null) {
            return asyncWorker.executeWorkAsync(k, this);
        } else {
            LOGGER.debug("Rejected [{}] as it's already being worked on", k);
            return v;
        }
    });
}