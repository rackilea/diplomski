Comparator<Parent> byAttr1ofFirstChild = Comparator.comparing(
    parent -> parent.getChildren().get(0).getAttr1()
);

Comparator<Parent> byAttr1ofFirstGrandChild = Comparator.comparing(
    parent -> parent.getChildren().get(0).getGrandChildren().get(0).getAttr1()
);


List<Parent> sortedList = parents.stream()
    .sorted(byAttr1ofFirstChild.thenComparing(byAttr1ofFirstGrandChild))
    .collect(toList());