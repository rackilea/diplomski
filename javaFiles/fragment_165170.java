@NamedEntityGraph(
  name = "report-eg",
  attributeNodes = {
    @NamedAttributeNode("foo"),
    @NamedAttributeNode(value = "bar", subgraph = "bar-eg"),
  },
  subgraphs = {
    @NamedSubgraph(
      name = "bar-eg",
      attributeNodes = {
        @NamedAttributeNode("qux")
      }
    )
  }
)