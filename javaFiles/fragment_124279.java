public List<InvoiceItems> findAllBalance(String external_key) throws HibernateException {
     Query query = session.createSQLQuery("select SUM(i.amount) as amount, t.record_id from Accounts a, InvoiceItems i, Tenant t WHERE a.record_id = i.account_record_id AND t.record_id=a.tenant_record_id  AND a.external_key='"+external_key+"' group by i.tenant_record_id, t.record_id");
    query.setResultTransformer(Transformers.aliasToBean(InvoiceItems.class));
     List<InvoiceItems> list = query.list();
        return list;
}