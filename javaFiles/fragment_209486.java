public void  loopDeproxyElements(List<Element> yourElementsCollection){
  for(Element p : yourElementsCollection){
      if(p instanceof HibernateProxy){
        Element child =   (Element) ((HibernateProxy) p).getHibernateLazyInitializer()
                    .getImplementation();

        if (child instanceof ElementTypeOne){

         //You can cast your object or do whatever you want, knowing for sure that's a child element)

          ElementTypeOne myRealElement =  (ElementTypeOne) child;
          ...
          } else {
           //It should be ElementTypeTwo (if u never create parent entities)
           ...
      }
    }        
  }
)