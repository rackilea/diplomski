public class PositionFormatter implements Formatter<Position> {

    private EntityManager entityManager;

    public PositionFormatter(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public String print(Position position, Locale locale) {
        if(position.getId() == null){
            return "";
        }

        return position.getId().toString();
    }

    public Position parse(String id, Locale locale) throws ParseException {
        return entityManager.getReference(Position.class, Long.parseLong(id));
    }
}