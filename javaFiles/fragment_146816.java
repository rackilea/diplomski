// DTO is the common superclass/subclass
public interface Addable<E extends DTO> {

    public int addItem(E dto);

}