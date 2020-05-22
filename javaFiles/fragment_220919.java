Collection<Target> merged = yourListOfTargets
            .stream()
            .collect(Collectors.toMap(
                    t -> List.of(t.getYear(), t.getMonth(), t.getName()),
                    Function.identity(),
                    (left, right) -> {
                        left.setTarget(left.getTarget() + right.getTarget());
                        left.setAchieved(left.getAchieved() + right.getAchieved());
                        return left;
                    }))
            .values();