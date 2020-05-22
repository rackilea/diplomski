private void findIslands(List<Hex> playersHexes, Hex currentHex, Map map, List<Hex> island)
{
  List<Hex> neighbours = map.getNeighboursOf(currentHex);

  // for each neighbour we check if it belongs to player and if it is not already part of this island
  for(Hex neighbour : neighbours) {
     if (!island.contains(neighbour) && playersHexes.contains(neighbour))  {
        island.add(neighbour);

        // now find all connecting neighbours of the current neighbour
        findIslands(playersHexes, neighbour, map, island);
     }
  }
  // now we have in island all connecting Hexes of current hex
}