String originalValue = "...";
String afterSortValue =
    Arrays.stream(originalValue.split(""))
          .sorted((o1, o2) -> {
                    Integer aPos = poses.get(o1);
                    Integer bPos = poses.get(o2);
                    if (aPos == null || bPos == null)
                      return 0;
                    return Integer.compare(aPos, bPos);
                  }
          )
         .collect(Collectors.joining());