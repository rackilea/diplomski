@Aspect
public class Village_Dao_Java {
    public static class VillageDao implements Dao<Village> {
        @Override
        public void insert() {
            Village.insertVillage(this);
        }

        @Override
        public void update() {
            Village.updateVillage(this);
        }

        @Override
        public void delete() {
            Village.deleteVillage(this.getVid());
        }

        public Village getData() {
            return getDataVillage(this.getVid());
        }

    }

    @DeclareParents(
        value = "de.scrum_master.app.Village",
        defaultImpl = VillageDao.class
    )
    private Dao<Village> villageDao;
}