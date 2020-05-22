@Override
public List<IncomeChannelCategoryMap> allIncomeChannels(final EntityRequest<IncomeChannel> request) throws ApiException {
    List<String> lists = request.getEntity().getIncomeChannels();
    List<IncomeChannelCategoryMap> channels = incomeChannelMapDAO.allIncomeChannels(lists);
    return new ArrayList<>(channels.stream().collect(Collectors.toMap(IncomeChannelCategoryMap::getIncomeChannelCode,
            Function.identity(), (i1, i2) -> {
                i1.setLogicalUnitIdent(i1.getLogicalUnitIdent() + ", " + i2.getLogicalUnitIdent());
                if (!i1.getLogicalUnitCode().contains(i2.getLogicalUnitCode())) {
                    i1.setLogicalUnitCode(i1.getLogicalUnitCode() + ", " + i2.getLogicalUnitCode());
                }
                return i1;
            })).values());
}