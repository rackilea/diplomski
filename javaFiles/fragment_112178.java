public void removeIndices(List<String> strings, List<Integer> indices)
{
     indices.stream()
         .sorted(Comparator.reverseOrder())
         .forEach(strings::remove);
}