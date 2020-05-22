import java.io.*;
import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.annotation.*;

public class Test
{
    public static void main(String[] args) {
        MyClass1 myc1 = new MyClass1("app1", "user1");
        MyClass1 myc2 = new MyClass2("app2", "user2", "err2", "rc2");

        try {
            System.out.println(new ObjectMapper().writeValueAsString(myc1));
            System.out.println(new ObjectMapper().writeValueAsString(myc2));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @JsonSerialize(using = MyClass1Serializer.class)
    public static class MyClass1 {
        protected String applicationName;
        protected String userName;

        public MyClass1() {}

        public MyClass1(String applicationName, String userName) {
            this.applicationName = applicationName;
            this.userName = userName;
        }

        public String getApplicationName() { return applicationName; }
        public String getUserName()        { return userName; }
    }

    @JsonSerialize(using = MyClass2Serializer.class)
    public static class MyClass2 extends MyClass1 {
        protected String errorMessage;
        protected String resultCode;

        public MyClass2() {}

        public MyClass2(String applicationName, String userName, String errorMessage, String resultCode) {
            super(applicationName, userName);
            this.errorMessage = errorMessage;
            this.resultCode = resultCode;
        }

        public String getErrorMessage() { return errorMessage; }
        public String getResultCode()   { return resultCode; }
    }

    public static class MyClass1Serializer<T extends MyClass1> extends JsonSerializer<T> {
        @Override
        public void serialize(MyClass1 myClass1, JsonGenerator jsonGenerator, SerializerProvider serializerProvider)
                throws IOException
        {
            jsonGenerator.writeStartObject();
            jsonGenerator.writeStringField("ApplicationName", myClass1.getApplicationName());
            jsonGenerator.writeStringField("UserName", myClass1.getUserName());
            //jsonGenerator.writeEndObject();
        }
    }

    public static class MyClass2Serializer extends MyClass1Serializer<MyClass2> {
        @Override
        public void serialize(MyClass2 myClass2, JsonGenerator jsonGenerator, SerializerProvider serializerProvider)
                throws IOException
        {
            super.serialize(myClass2, jsonGenerator, serializerProvider);
            jsonGenerator.writeStringField("ErrorMessage", myClass2.getErrorMessage());
            jsonGenerator.writeStringField("ResultCode", myClass2.getResultCode());
            //jsonGenerator.writeEndObject();
        }
    }
}