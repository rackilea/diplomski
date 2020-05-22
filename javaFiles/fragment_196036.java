// the initial data
ArrayList<String> data = ...;

// submit a call for each element separately
CompletableFuture[] futures = data.stream()
         .map(datum -> CompletableFuture.supplyAsync(() -> {
              // do call
          }))
          .toArray(CompletableFuture[]::new);

// wait for all the calls to finish
CompletableFuture.allOf(futures);