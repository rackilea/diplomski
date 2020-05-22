periods.stream()
        .map(p -> Range.closedOpen(p.getStart(), p.getEnd()))
        .collect(TreeRangeSet::<Integer>create, RangeSet::add, RangeSet::addAll)
        .asRanges()
        .stream()
        .map(r -> new PeriodImpl(r.lowerEndpoint(), r.upperEndpoint()))
        .collect(Collectors.toList());