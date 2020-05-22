<T> void visitElement(Element e,  
        BiFunction<Collection<T>, T, Boolean> elementOp) {  
   ...
   elementOp.apply(idCodes, e.getIdCode());
   elementOp.apply(weights, e.getWeight());
}