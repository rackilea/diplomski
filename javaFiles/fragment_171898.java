project.getProcesses().values().stream()
        .filter(x -> 
                x.getActivities().values().stream().anyMatch(
                        y -> "starter".equals(y.getType())
                )
        );