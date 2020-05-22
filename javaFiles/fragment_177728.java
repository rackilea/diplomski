public void flip()
{
    List<Block[]> blocksAsList = Arrays.asList(blocks);
    Collections.reverse(blocksAsList);
    blocks = blocksAsList.toArray();
}