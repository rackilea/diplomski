enum MetaType {
 HUMAN(new MyRange(1,1), new MyRange(1, 10), new MyRange(1,10)
 ),
 ORK(new MyRange(1,1), new MyRange(1, 10), new MyRange(1,10)
 );

 MetaType(MyRange body, MyRange agility, MyRange reaction) {
      this.bodyAttrib = new MetaTaypAttibute(AttributeType.BODY, body);
      this.agilityAttrib = new MetaTaypAttibute(AttributeType.AGILITY, agility);
      this.reactionAttrib = new MetaTaypAttibute(AttributeType.REACTION, reactiony);}
}