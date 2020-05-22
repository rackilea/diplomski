List<SomeObject> result = response.getContent()
                                  .stream()
                                  .map(dto::map)
                                  .collect(Collectors.toList());

// do something with result if you need.