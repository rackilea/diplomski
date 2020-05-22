Optional.ofNullable(response.body())
.stream()
.reduce(
                        new NutritionAccumulator(),
                        (acc, fudNut) -> new NutritionAccumulator(
                                fudNut.getTotalFat(),
                                fudNut.getTotalCarbohydrate(),
                                fudNut.getDietaryFiber(),
                                fudNut.getProtein()
                        ).add(acc),
                        NutritionAccumulator::add

                );