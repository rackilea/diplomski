out: {
      switch (req.getCurrency()) {
        case EUR: 
        case GBP:
        case USD: break out;
        case UNKNOWN:
          responseObserver.onError(
              Status.INVALID_ARGUMENT
                  .withDescription("bad currency " + req.getCurrency())
                  .asRuntimeException());
          return;
      }
      throw new AssertionError("missed case!");
    }
    // keep handling the request