for (int i = 0; i < list.size(); i++){
   int lineNo= list.get(i).getLineNo();
   String statment = list.get(i).getStatement();
   int cmplxCount= list.get(i).getCmplxCount();

   Object[] data = {lineNo, statement , cmplxCount};
   tableModel.add(data);
}