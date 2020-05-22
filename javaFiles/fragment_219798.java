import java.lang.reflect.*;

class SomeObject{
    private String string;

    void setString(String value){
        string= value;
    }
}

class TestPrivateAccess{
    public static void main(String[] args) throws Exception{
        SomeObject ojb = new SomeObject();
        obj.setString("astring");

        Field field = SomeObject.class.getDeclaredField("string");
        field.setAccessible(true);
        Object value = field.get(obj);
        System.out.println(value);
    }
}