private String[][] valores;
Fetch process = new Fetch();
  process.execute();
   try {
      valores=process.get();
     } catch (ExecutionException e) {
        e.printStackTrace();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      pm.setText(String.valueOf(valores[Fetch.Key][0]));
   }
  }
}