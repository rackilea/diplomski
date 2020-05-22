sb.append(rendern(table(each(fsc.getCounters().entrySet(), next ->
        tr(
                td(
                        label(next.getValue().getText())
                                .attr(FOR,PB_PREFIX+next.getKey().intValue())),
                td(
                        iffElse(next.getValue().getBar().isIndeterminate(),
                                progress()
                                        .withId(PB_PREFIX+next.getKey().intValue()),
                                progress()
                                        .withId(PB_PREFIX+next.getKey().intValue())
                                        .attr(VALUE, next.getValue().getCounter().intValue())
                                        .attr(MAX, next.getValue().getBar().getMaximum())
                        )
                )
        )
    )
)));