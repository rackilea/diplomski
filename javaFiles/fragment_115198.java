ParentBean parent = new ParentBean();
parent.setName( "test parent");

List<ChildBean> revList = new ArrayList<>();

ChildBean child = new ChildBean();
child.setName( "test child" );

revList.add ( child );

child.setParent( parent ); // don't forget this.
parent.setRevisionList( revList );