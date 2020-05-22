package com.shashi.mpoole;


import java.io.File;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

public class XMLValid {

    /**
     * @param args
     */
    public static void main(String[] args) throws Exception {
        // TODO Auto-generated method stub

        if(validateAgainstXSD(new File("connector/connector.xml")))
        {
            System.out.println("Success");
        }
        else
        {
            System.out.println("Failure");
        }
    }



    static boolean validateAgainstXSD(File xml){
        try{

            SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = factory.newSchema(new StreamSource("connector/connector.xsd"));

            Validator validator  = schema.newValidator();
            validator.validate(new StreamSource(xml));
            return true;
        }catch(Exception exe){
            exe.printStackTrace();
        return false;
        }
    }

}