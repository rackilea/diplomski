@ManagedBean
@RequestScoped
public class ArrayBean {

    private Integer[][] array = { { 1, 2, 3 }, { 1 } };

    public Integer[][] getArray() {
        return array;
    }

}