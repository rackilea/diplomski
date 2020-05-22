private void propagateFlagWeekIsIncludedToTheAllDemos(List<BaselineRatingsSweepsTableDataDTO> sweepsDataPerDemo) {
    if (sweepsDataPerDemo.isEmpty()) {
        return; // No primary ... nothing
    }

    BaselineRatingsSweepsTableDataDTO tableForPrimaryDemo = sweepsDataPerDemo.get(0);
    sweepsDataPerDemo.stream()
            .skip(1) // skip primary table
            .forEach(tableForAdditionalDemo -> processTablePair(tableForPrimaryDemo, tableForAdditionalDemo)); // Process remaining demos ( secondary,tertiary .. )
}


private void processTablePair(BaselineRatingsSweepsTableDataDTO tableForPrimaryDemo,
                              BaselineRatingsSweepsTableDataDTO tableForAdditionalDemos) {
    processSweeps(tableForPrimaryDemo.getSweeps(), tableForAdditionalDemos.getSweeps());
}

private void processSweeps(List<BaselineRatingsSweepDataDTO> sweepsForPrimaryDemo,
                           List<BaselineRatingsSweepDataDTO> sweepsForAdditionalDemos) {
    // TODO: assert equal sizes
    Seq.zip(sweepsForPrimaryDemo, sweepsForAdditionalDemos)
            .forEach(tuple -> processSweepPair(tuple.v1(), tuple.v2()));
}

private void processSweepPair(BaselineRatingsSweepDataDTO sweepForPrimaryDemo,
                              BaselineRatingsSweepDataDTO sweepForAdditionalDemo) {
    copyIncludeFlag(sweepForPrimaryDemo.getWeeks(), sweepForAdditionalDemo.getWeeks());
}

private void copyIncludeFlag(List<BaselineRatingsSweepWeekDataDTO> primaryWeeks,
                             List<BaselineRatingsSweepWeekDataDTO> additionalWeeks) {
    // TODO: assert equal sizes
    Seq.zip(primaryWeeks, additionalWeeks)
            .filter(tuple -> tuple.v1().getWeek().equals(tuple.v2().getWeek()))
            .forEach(tuple -> tuple.v1().setIsIncluded(tuple.v2().getIsIncluded()));
}