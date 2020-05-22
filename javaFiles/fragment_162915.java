@Any(metaColumn = @Column(name = "ITEM_TYPE"))
@AnyMetaDef(idType = "int", metaType = "int", 
        metaValues = { 
         @MetaValue(targetEntity = Book.class, value = "0"),
         @MetaValue(targetEntity = Food.class, value = "1")
   })
@JoinColumn(name="ITEM_ID")
private Object item;