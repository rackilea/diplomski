abstract class Model {

    private PersistenceManager persistenceManager = new PersistenceManager();

    abstract String getTableName();
    abstract Model map(Object persistenceResult);

    public void load(Map<String, Object> data) {
        Object persistenceResult = persistenceManager.create(data, getTableName());

        //Set appropriate fields on this class.
        map(persistenceResult);
    }
}

class User extends Model {

    @Override
    String getTableName() {
        return "Users";
    }

    @Override
    Model map(Object persistenceResult) {
        //Mapping logic.
        return null;
    }
}

class PersistenceManager {

    public Object create(Map<String, Object> data, String tableName) {
        //Persistence logic.

        //Return result of DB insert here.
        return null;
    }
}

class ModelFactory {

    public static Model createModel(Class modelClass, Map<String, Object> data) {
        Model model;
        if (modelClass == User.class) {
            model = new User();
        } else {
            //Cater for other models.
            throw new IllegalArgumentException("Invalid model.");
        }

        model.load(data);

        return model;
    }
}