String json = http.sendGet(WSChamada);
System.out.println(json); // imprimme padrão 
// criando array de json para gson para impresão
Gson g = new Gson();
ConsultaWSCep c = g.fromJson(WSChamada, ConsultaWSCep.class);
System.out.println(c.getCep());