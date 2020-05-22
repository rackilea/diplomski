@POST
    @Path("/byPeriodo")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public List<ItemProdutividade> getProdutividadeByPeriodo(@FormParam("dataInicial")
    long dataInicial, @FormParam("dataFinal") long dataFinal,
    @FormParam("cpf") long cpf){
        return service.getProdutividadeByPeriodo(DateUtils.toLocalDate(new Date(dataInicial)),
                DateUtils.toLocalDate(new Date(dataFinal)), cpf);
    }