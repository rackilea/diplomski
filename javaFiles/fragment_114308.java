public class DBDrivenPayloadHandler extends GDE{
DbDrivenPayloadHandlerBean bean;

@SuppressWarnings("rawtypes")
public void populateBean() throws Exception {
    ITransaction trans = new MySQLTransaction();
    IAdapterDataMapDAO adapterDataMap = new MySQLAdapterDataMapDAO();
    adapterDataMap.setTransaction(trans);

    HashMap<String, String> values = adapterDataMap.getHashMap(super.getCurrentAccountId());        
    this.bean = new DbDrivenPayloadHandlerBean(); 

    Iterator it = values.entrySet().iterator();
    while (it.hasNext()) {
        Map.Entry entry = (Map.Entry)it.next();
        try {
            BeanUtils.setProperty(bean, (String) entry.getKey(), entry.getValue()); 
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

public void getInfo(String fileName) {
    try {
        populateBean();
    } catch (Exception e) {
        e.printStackTrace();
    }
    APPTS_FULLNAME_POS = bean.getAPPTS_FULLNAME_POS();
    APPTS_DATETIME_POS = bean.getAPPTS_DATETIME_POS();
    //Both still -1;
    super.getInfo(filename);
}