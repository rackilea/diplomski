experiments.stream()
           .map(e -> new ExperimentWithTags(
                e, 
                tags.stream()
                    .filter(t -> e.getId().equals(t.getExperimentId()))
                    .collect(Collectors.toList())
           ));