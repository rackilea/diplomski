BaseType type = (BaseType) message.getAbstractGroup().getValue();

if (type instanceof ActualType1) {
     System.out.println(((ActualType1) type).getTitle());
} else if (type instanceof ActualType2) {
     System.out.println(((ActualType2) type).getSubject());
}