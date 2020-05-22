List<PopulationForState> populationForStates = new ArrayList<>();
populationForStates.add(new PopulationForState(...));
populationForStates.add(new PopulationForState(...));

Collection.sort(populationForStates, Comparator.comparing(PopulationForState::population).reversed()
          .thenComparing(PopulationForState::getCity)
          .thenComparing(PopulationForState::getState);

populationForStates.stream()
                   .forEach(PopulationForState::sortInnerStates);