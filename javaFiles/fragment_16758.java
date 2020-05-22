for (Item item : pOSBean.getItemList())
{
    valueDTO = new ValueDTO();
    valueDTO.setRowId(1);
    valueDTO.setValue(item.getDiscountCode());
    valueListDTO.add(valueDTO);
}