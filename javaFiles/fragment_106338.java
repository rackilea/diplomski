private void addObjective(TreeItem<Object> specificGoal, List<Strategy > objective){
    TreeItem<Object> objectiveTreeItem = new TreeItem<>(objective);

    for(List<Tactic> strategy: objective){
        addStrategy(objectiveTreeItem, strategy);
    }
    specificGoal.getChildren().add(objectiveTreeItem);
}