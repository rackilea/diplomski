public  MessageType getOrgReversalTargetMti(Map<MessageType, List<TVO>> map) {
    return map.entrySet()
              .stream()
              .max(Comparator.comparing(e -> e.getValue().get(0).getTrace()))
              .map(Map.Entry::getKey())
              .orElse(null);
}