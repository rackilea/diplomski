public void updateField(){
    Query q=getSessionFactory().getCurrentSession().createQuery(
        " update SapOrderHDR set
            SAP_ORDER_STATUS = 'A' where BC_ORDER_NO='" + bcOrderNo + "'");
    q.executeUpdate();
}