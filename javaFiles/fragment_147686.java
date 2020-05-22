List<DetalheRateio> novos = (List<DetalheRateio>) CollectionUtils.subtract(detalheRateios, detalheRateiosBd);
List<DetalheRateio> excluidos = (List<DetalheRateio>) CollectionUtils.subtract(detalheRateiosBd, detalheRateios);
List<DetalheRateio> detalhesAlterados = new ArrayList<DetalheRateio>();

detalheRateiosBd.removeAll(excluidos);
detalheRateiosBd.addAll(novos);

for (DetalheRateio detalheExcluido : excluidos) {
    getEntityManager().remove(detalheExcluido);
}

for (DetalheRateio dRateio : detalheRateios) {
    detalhesAlterados.add(getEntityManager().merge(dRateio));
}

rateio.setDetalheRateios(detalhesAlterados);
setInstance(rateio);
result = super.update();
getEntityManager().flush();