list.stream()
    .collect(Collectors.collectingAndThen(
                        Collectors.groupingBy(x->x.getDate(), 
                        lr -> {
                            Map<CustomEnum, String> result = new EnumMap<>();
                            Rating r = lr.get(0); // take first rating for that date
                            result.put(CustomEnum.aRatingEnum, r.getARating());
                            result.put(CustomEnum.bRatingEnum, r.getBRating());
                            return result;
                        })));