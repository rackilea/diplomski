public class Test {

    int id;
    int height;
    String name;

    public Test(int id, int height, String name) throws HeightException, NameException, IdException {
        setHeight(height);
        setId(id);
        setName(name);
    }

    public static void main(String[] args) {
        try {
            Test tes = new Test(1, 2, "Hello")
        } catch (HeightException e) {
            //height is wrong
            e.printStackTrace();
        } catch (NameException e) {
            //name is wrong
            e.printStackTrace();
        } catch (IdException e) {
            //id is wrong
            e.printStackTrace();
        }
    }

    public void setId(int id) throws IdException {
        if (id >= 200)
            throw new IdException("Id is wrong it must be lower than 200");
        this.id = id;

    }

    public void setHeight(int height) throws HeightException {
        if (height >= 100 && height <= 250) {
            this.height = height;
        } else
            throw new HeightException("Height is wrong it must be between 100 and 250");
    }

    public void setName(String name) throws NameException {
        if (name.length() >= 20)
            throw new NameException("Name is wrong it must be less than 20 characters");
        this.name = name;
    }

    class NameException extends Exception {
        NameException(String message) {
            super(message);
        }
    }

    class HeightException extends Exception {
        HeightException(String message) {
            super(message);
        }
    }

    class IdException extends Exception {
        IdException(String message) {
            super(message);
        }
    }
}