public void execute(String x) {


      ArrayList<operations> ops= new ArrayList<operations>();
      for(int i=0; i< functi.size();i++) {
         operations op = new operations();
         op.stream = str.get(i);
         op.funct = functi.get(i);
         op.funcgroup = functigroup.get(i);
         op.name = nme.get(i);
         op.source = src.get(i);
         ops.add(op);
      }


     Map<String,ArrayList<operations>> map = new HashMap<String, ArrayList<operations>>();
     map.put(x, ops);

     for (operations operation : map.get(x)) {
         System.out.println(operation.name);
     }

}