import com.se.sas.persistance.utils.HibernateUtils;

public class FinderWorker implements Runnable {


    @Override
    public void run() {
        operateOnList(getNParts(IndexLocker.getAllowedListSize()));

    }

    public List<Parts> getNParts(int listSize) {

        try {

            criteria = .....
            // *********** SYNCHRONIZATION OCCURS HERE ********************//
            criteria.setFirstResult(IndexLocker.getAvailableIndex());
            criteria.setMaxResults(listSize);
            partList = criteria.list();

        } catch (Exception e) {
            e.printStackTrace();

        } finally {

            session.close();
        }
        return partList;
    }

    public void operateOnList(List<Parts> partList) {
    ....
    }

}