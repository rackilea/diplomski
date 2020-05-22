import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeConstants;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class TestJSONDeserialize {

    public static void main(String[] args){

        ObjectMapper mapper = new ObjectMapper();
        mapper.addMixIn(Data.class, NewMixin.class);

        String jsonString = "{\"date\":\"2014-02-10\",\"time\":\"16:15:00\"}";
        Data data = null;
        try {
            data = mapper.readValue(jsonString, Data.class);
        } catch (JsonParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (JsonMappingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        if(data != null){
            System.out.println(" Data " + data.getDate());
            System.out.println(" Data " + data.getTime());
        }   
    }


}



import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class CustomDateDeserializer extends JsonDeserializer<XMLGregorianCalendar> {

    private static SimpleDateFormat formatter = 
      new SimpleDateFormat("yyyy-MM-dd");


    @Override
    public XMLGregorianCalendar deserialize(JsonParser jsonparser, DeserializationContext arg1) throws IOException, JsonProcessingException {
        // TODO Auto-generated method stub
        String date = jsonparser.getText();
        try {

            GregorianCalendar c = new GregorianCalendar();
            c.setTime(formatter.parse(date));
            XMLGregorianCalendar date2 = null;
            try {
                date2 = DatatypeFactory.newInstance().newXMLGregorianCalendar(c);
            } catch (DatatypeConfigurationException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            return date2;
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
}




import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class CustomTimeDeserializer extends JsonDeserializer<XMLGregorianCalendar> {

    private static SimpleDateFormat formatter = 
      new SimpleDateFormat("hh:mm:ss");


    @Override
    public XMLGregorianCalendar deserialize(JsonParser jsonparser, DeserializationContext arg1) throws IOException, JsonProcessingException {
        // TODO Auto-generated method stub
        String date = jsonparser.getText();
        try {

            GregorianCalendar c = new GregorianCalendar();
            c.setTime(formatter.parse(date));
            XMLGregorianCalendar date2 = null;
            try {
                date2 = DatatypeFactory.newInstance().newXMLGregorianCalendar(c);
            } catch (DatatypeConfigurationException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            return date2;
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
}



import javax.xml.datatype.XMLGregorianCalendar;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

abstract class NewMixin {

    @JsonDeserialize(using = CustomDateDeserializer.class)
    public abstract void setDate(XMLGregorianCalendar date);

    @JsonDeserialize(using = CustomTimeDeserializer.class)
    public abstract void setTime(XMLGregorianCalendar time);
}