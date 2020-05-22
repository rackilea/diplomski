public void valueChanged(TreeSelectionEvent e) 
{
    DefaultMutableTreeNode currentNode = (DefaultMutableTreeNode)tree.getLastSelectedPathComponent();
    if(currentNode != null){         
        Object nodeInfo = currentNode.getUserObject();
        Question questionText = (Question)nodeInfo;
        txtQuestion.setText(questionText.getQuestion()); 
    }
}};