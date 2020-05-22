public class FreePortsBuilder {
  private TreeBuilder treeBuilder;
  private PortLabelGenerator portLabelGenerator;

  public FreePortsBuilder(TreeBuilder treeBuilder, PortLabelGenerator portLabelGenerator) {
    this.treeBuilder = treeBuilder;
    this.portLabelGenerator = portLabelGenerator;
  }

  public Set<PortNameAndLabel> collectFreePorts() {
    Tree<EquipmentDetails> tree = treeBuilder.buildTree();
    return collectFreePorts(tree);
  }

  private Set<PortNameAndLabel> collectFreePorts(Tree<EquipmentDetails> tree) {
    Set<PortNameAndLabel> portNameAndLabels = new HashSet<>();

    for (Tree<EquipmentDetails> child : tree.getChildren()) {
      Map<String, NativeSlotDisplayLabel> childSubTypeMap =
          treeBuilder.getNodeHelper().getChildSubTypeMap(child);

      if (CommonUtils.nullOrEmpty(childSubTypeMap))
        continue;

      Set<PortNameAndLabel> generatedPortNameAndLabel =
          portLabelGenerator.getPortNameAndLabel(childSubTypeMap, child.getUserObject());

      portNameAndLabels.addAll(generatedPortNameAndLabel);
    }

    return portNameAndLabels;
  }
}