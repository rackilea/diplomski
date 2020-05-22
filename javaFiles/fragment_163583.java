public void CreateTree()
{
        root = new Node("adam");
        AddChilds(root);
}


public void AddChilds(Node tree)
{
        String SQL="select name from BB where father='"+root.getData()+"' ;
        ResultSet rs = statement.executeQuery(SQL);
        while(rs.next())
        {
           Node child= new Node(rs.getString("name"));
           child.parent = tree;
           tree.addChild(child);//tree.children.Add(child);
        }
        tree.children.ForEach(X => { AddChilds(X); });
  }