public static void main(String... args) {
    Venda v = new Venda();
    UserAccount ua = new UserAccount();
    v.setId(1L);
    ua.setId(1L);
    ua.addVenda(v);
    try {
        ObjectMapper mapper = new ObjectMapper();
        System.out.println("UserAccount: (unfiltered)");
        System.out.println(mapper.writeValueAsString(ua));

        mapper = new ObjectMapper();
        // register module at run time to apply filter
        mapper.registerModule(new Venda.FilterCliente());
        System.out.println("UserAccount: (filtered)");
        System.out.println(mapper.writeValueAsString(ua));

        mapper = new ObjectMapper();
        System.out.println("Venda: (unfiltered)");
        System.out.println(mapper.writeValueAsString(v));

        mapper = new ObjectMapper();
        // register module at run time to apply filter
        mapper.registerModule(new UserAccount.FilterVendas());
        System.out.println("Venda: (filtered)");
        System.out.println(mapper.writeValueAsString(ua));
    } catch (Exception e) {
        e.printStackTrace();
    }
}