// Override
@Override
public long insert(Document doc){
    if (!(doc instanceof Page))
         throw new IlegalArgumentException("insert only accepts Page");
    super.insert(doc);
}

// Overload
public long insert(Page page){
    super.insert(page);
}