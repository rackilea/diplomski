List<Long> rows =  query.list();
     System.out.println("current row>>>>>>  " +rows.toString());

      for (Long val: rows) {
            System.out.println(" ------------------- ");
            System.out.println("current file: " + val);
      }