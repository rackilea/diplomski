@Transactional
public boolean upsert(Object d) {
try {
    SessionLocator.currentSession().saveOrUpdate(d);

    } catch (Exception e) {

    e.printStackTrace();
    return false;
   }
   return true;
   }