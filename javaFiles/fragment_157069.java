response.getFirstNodes()
        .stream()
        .filter(first -> first.isValid())
        .flatMap(first -> first.getSndNodes().stream())
        .filter(snd -> snd.getType() == NodeType.AMOUNT)
        .mapToDouble(snd -> snd.getAmount())
        .sum();