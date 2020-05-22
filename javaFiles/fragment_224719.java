final Map<Integer, List<TopTerminalDto>> map = 
             list.stream()
                 .filter(p -> p.getTerminal() != null)
                 .collect(groupingBy(
                     p -> p.getTerminal(),
                     Collector.of(
                            ArrayList::new,
                            (terminals, p) -> terminals.add(toDto(p)),
                            (accumulator, terminals) -> {
                                accumulator.addAll(terminals);
                                return accumulator;
                            }
                     )
             ));