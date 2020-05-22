List<Colors> startColors = new ArrayList<>(Arrays.asList(new Colors[]{Colors.RED, Colors.PINK}));
List<Colors> availableColors = new ArrayList<>(Arrays.asList(Colors.values()));
availableColors.removeAll(startColors);
startColors.addAll(availableColors);

System.out.println(startColors);