Map<Dir, Cell> neighbours = 
    Collections.synchronizedMap(new EnumMap<Dir, Cell>(Dir.class));

neighbours.put(Dir.North, new Cell());

for (Map.Entry<Dir, Cell> neighbour : neighbours.entrySet()) {
    if (neighbour.isVisited()) { ... }
}

etc..