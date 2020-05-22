VBox vb = new VBox();
vb.setAlignment(Pos.CENTER);
TextField tf1 = new TextField();
...

ModbusTCPTransaction trans = new ModbusTCPTransaction(con);

Runnable r = new ... //see code above
new Thread(r).start(); //starts the polling