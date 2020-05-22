Condition condition = RECEIPT.TSCCREATED.between(start, end)
    .and(OUTLET.OWNERID.eq(ownerId));

if (outletId != null) {
    condition = condition.and(RECEIPT.OUTLETID.eq(outletId));
}
if (merchantId != null) {
    condition = condition.and(RECEIPT.MERCHID.eq(merchantId));
}

Select<Record5<String, BigDecimal, Integer, Timestamp, Long>> select =
db.select(
       WARE.NAME, 
       RECEIPTITEM.SALEPRICE, 
       RECEIPTITEM.QUANTITY, 
       RECEIPT.TSCCREATED, 
       WARE.WARECATEGORYID)
  .from(RECEIPT
      .join(RECEIPTITEM).on(RECEIPT.ID.eq(RECEIPTITEM.RECEIPTID))
      .join(OUTLET).on(OUTLET.ID.eq(RECEIPT.OUTLETID))
      .join(WARE).on(WARE.ID.eq(RECEIPTITEM.WAREID)))
  .where(condition);