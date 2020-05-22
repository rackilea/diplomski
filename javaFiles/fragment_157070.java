response.getFirstNodes()
                .stream()
                .filter(first -> first.isValid())
                .map(first -> first.getSndNodes().stream().filter(snd -> snd.getType() == NodeType.AMOUNT).findFirst())
                .filter(Optional::isPresent)
                .mapToDouble(opt -> opt.get().getAmount())
                .sum();