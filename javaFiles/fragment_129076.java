package formatter;

import java.io.*;
import java.lang.String;
import java.nio.charset.StandardCharsets;
import java.util.List;

import oracle.kv.*;
import com.google.gson.Gson;
import oracle.kv.KeyValueVersion;
import oracle.kv.exttab.Formatter;

public class TweetFormatter implements Formatter {

    public TweetFormatter() {
        super();
    }

    public String toOracleLoaderFormat(final KeyValueVersion kvv, final KVStore kvStore){

        String valor_retorno= null;

        Tweet tw; //antes sin null

        BufferedWriter bf = FormatterUtils.getInstance().getWriter();

        try {
            final Key key = kvv.getKey();
            final Value value = kvv.getValue();
            Value.Format format = value.getFormat();

            FormatterUtils.getInstance().writeLine(bf,"[Key: "+ key + ", Value:" +value.toByteArray()+ "]" + ". Format= "+ format.toString());

            //Filtrar Clave
            List<String> major = key.getMajorPath();

            FormatterUtils.getInstance().writeLine(bf,"Check 1:\n Key is: "+key + "\n Key length is: "+major.size()
                    + "\n Values are: "+major.toString() + "\n contains: "+major.contains("TweeterStream"));

            Boolean contains = false;

            for(String x : major) {
                if(x.equals("TweeterStream")||x.equals("/TweeterStream")||x.equals("/TweeterStream/")) {
                    contains = true;
                    break;
                }
            }

            //Parsear
            if(contains){

                String data = new String(value.toByteArray(),StandardCharsets.UTF_8);

                data = data.trim();
                tw = new Gson().fromJson(data,Tweet.class); //FUNCIONA

                FormatterUtils.getInstance().writeLine(bf,"Check 3 - El formatter retorna:\n"+tw.toString());
                valor_retorno = tw.toString();
            }else{
                FormatterUtils.getInstance().writeLine(bf,"\nEstoy en else");
            }
            FormatterUtils.getInstance().writeLine(bf,"\nestoy fuera del if-else");
        }  catch (Exception e) {
            e.printStackTrace();
            FormatterUtils.getInstance().writeLine(bf, "\nException " + e.getClass() + ": " + e.getMessage());
        } finally {
            FormatterUtils.getInstance().writeLine(bf,"\nReturn: Valor_retorno = "+valor_retorno);
            FormatterUtils.getInstance().generateLog(bf);
        }
        return valor_retorno;
    }