RequestQueue requestQueue;
WeakHashMap<StringRequest, String> queuedRequests;

// ...

private boolean addRequestToQueue(StringRequest request, String tag) {
    for(StringRequest queuedRequest : queuedRequests.keySet()) {
        if(tag.equals(queuedRequest.getTag())) {
            return false;
        }
    }

    request.setTag(tag);
    requestQueue.add(request);
    queuedRequests.put(request, tag);

    return true;
}