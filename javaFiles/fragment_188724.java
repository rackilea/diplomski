public class EnumEqualsMyCriteria<T extends Enum<T>> extends AbstractMyCriteria<T>{
private T value;



public EnumEqualsMyCriteria(String code,T value) {
    super(code);
    this.value=value;
}


@Override
public T getValue() {
    return value; 
}

public static void main(String[] args) {
    EnumEqualsMyCriteria<Type> ec=new EnumEqualsMyCriteria<Type>("Name", Type.Entity);
}
}