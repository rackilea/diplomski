DetachedCriteria msgFromCriteria = DetachedCriteria.forClass(Message.class);
ProjectionList properties = Projections.projectionList();
properties.add(Projections.groupProperty("messageFrom"));
properties.add(Projections.min("id"),"id");
msgFromCriteria.setProjection(properties);

Criteria criteria = s.createCriteria(Message.class);
criteria.add(Subqueries.propertiesIn(new String[]{"messageFrom","id"}, 
    msgFromCriteria));
List<Message> list = criteria.list();

for(Message message:list){
    System.out.println(message.getId()
        +"-------"
        +message.getMessageFrom()
        +"-----"
        +message.getFoobar());
}