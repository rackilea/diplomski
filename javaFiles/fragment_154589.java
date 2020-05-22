public static boolean hasCycle(Skill entry, List<UUID> visited, List<UUID> recursion) {
  UUID currentId = entry.getId();

  if (recursion.contains(currentId))
    return true;

  if (visited.contains(currentId))
    return false;

  visited.add(currentId);
  recursion.add(currentId);

  for (final Skill prerequisite : entry.getPrerequisites()) {
    if (hasCycle(prerequisite, visited, recursion)) {
      return true;
    }
  }

  recursion.remove(currentId);

  return false;
}