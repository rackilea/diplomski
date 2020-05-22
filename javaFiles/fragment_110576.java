WebTarget[] arr = { getClient().target(u) };
queryParams.entrySet()
           .stream()
           .forEachOrdered(e -> arr[0] = arr[0].queryParam(e.getKey(),
                                                           e.getValue()));
WebTarget target = arr[0];