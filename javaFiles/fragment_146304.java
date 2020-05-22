public abstract class BaseService<T, R> {

private JpaRepository<T, Integer> repository;

    public <T extends BaseEntity, R  extends BaseDto> void save(R r){
    T t = null;

    if (r == null) {
        //throw error
    }

    if (r.getId() != null) {
        Optional<T> tOpt = null;
        try {
            tOpt = (Optional<T>) repository.findById(t.getClass().getField("id").getInt(t));
        } catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException ex) {
            Logger.getLogger(BaseService.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (tOpt!=null && tOpt.isPresent()) {
            t = tOpt.get();
        }
    }

    repository.save(convertToBeans(r));
    }

public abstract T convertToBeens(R dto);
}