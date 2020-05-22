package com.tobee.tests.parse.json;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonParseTest {

    private static final String filePath = "resource/aa/mytest2.json";

    private static void searchJSONObject(JSONObject obj) {
        JSONObject jobj = obj;

        Set keyset = jobj.keySet();

        for (Iterator iter2 = keyset.iterator(); iter2.hasNext();) {
            String key = (String) iter2.next();
            Object value = jobj.get(key);

            if(value instanceof JSONObject)
            {
                searchJSONObject((JSONObject)value);
            }
            else
            {
                System.out.println(key + "=" + (String)value);
            }
        }

    }

    private static void searchJSONArray(JSONArray arry) {
        JSONArray jarry = arry;
        JSONObject jobj = null;

        for (Iterator iter = jarry.iterator(); iter.hasNext();) {
            Object o = iter.next();
            if (o instanceof JSONArray) {
                searchJSONArray((JSONArray) o);
            } else if (o instanceof JSONObject) {
                jobj = (JSONObject) o;
                Set keyset = jobj.keySet();

                for (Iterator iter2 = keyset.iterator(); iter2.hasNext();) {
                    String key = (String) iter2.next();
                    Object value = jobj.get(key);

                    if(value instanceof JSONObject)
                    {
                        System.out.println("[" + key + "]");
                        searchJSONObject((JSONObject)value);
                    }
                    else
                    {
                        System.out.println(key + "=" + (String)value);
                    }
                }
            }

        }
    }

    public static void main(String[] args) {

        try {

            // read the json file
            FileReader reader = new FileReader(filePath);

            JSONParser jsonParser = new JSONParser();

            Object jsonThing = jsonParser.parse(reader);

            if (jsonThing instanceof JSONArray) {
                searchJSONArray((JSONArray) jsonThing);
            } else if (jsonThing instanceof JSONObject) {
                JSONObject jobj = (JSONObject) jsonThing;

                Set keyset = jobj.keySet();

                for (Iterator iter2 = keyset.iterator(); iter2.hasNext();) {
                    String key = (String) iter2.next();
                    String value = (String) jobj.get(key);

                    System.out.println(key + "=" + value);

                }
            }

        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ParseException ex) {
            ex.printStackTrace();
        } catch (NullPointerException ex) {
            ex.printStackTrace();
        }

    }

    @SuppressWarnings({ "unchecked", "unused", "rawtypes" })
    public static void your_main(String[] args) {

        try {

            // read the json file
            FileReader reader = new FileReader(filePath);

            JSONParser jsonParser = new JSONParser();
            JSONObject jo = (JSONObject) jsonParser.parse(reader);

            // get a String from the JSON object
            Long TestScenario = (Long) jo.get("TestScenario");
            System.out.println("TestScenario " + TestScenario);

            String Transaction = (String) jo.get("Transaction");
            System.out.println("Transaction " + Transaction);

            String Description = (String) jo.get("Description");
            System.out.println("Description " + Description);

            String Cono = (String) jo.get("Co-no");
            System.out.println("Co-no " + Cono);

            JSONArray Parameters = (JSONArray) jo.get("Parameters");

        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ParseException ex) {
            ex.printStackTrace();
        } catch (NullPointerException ex) {
            ex.printStackTrace();
        }

    }

}