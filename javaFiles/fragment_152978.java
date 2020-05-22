public class Factory {

    public ParentDTO createDTO(Parent parent) {
        return new ParentDTO();
    }
    public FirstChildDTO createDTO(FirstChild firstChild) {
        return new FirstChildDTO();
    }
    public SecondChildDTO createDTO(SecondChild SecondChild) {
        return new SecondChildDTO();
    }
}

public class Parent {
}

public class FirstChild extends Parent {
}

public class SecondChild extends Parent {
}

public class ParentDTO {

    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }
}

public class FirstChildDTO extends ParentDTO {

    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }
}

public class SecondChildDTO extends ParentDTO {

    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }
}

public class App {

    public static void main(String[] args) {
        Factory factory = new Factory();
        ParentDTO parentDTO = factory.createDTO(new Parent());
        System.out.println(parentDTO);
        FirstChildDTO firstChildDTO = factory.createDTO(new FirstChild());
        System.out.println(firstChildDTO);
        SecondChildDTO secondChildDTO = factory.createDTO(new SecondChild());
        System.out.println(secondChildDTO);
    }
}