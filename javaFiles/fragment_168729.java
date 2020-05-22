import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

public class JsonTable {
    JsonParser parser;

    public JsonTable( String filename ) {
        try {
            JsonFactory f = new JsonFactory();
            InputStream stream = Thread.currentThread().getContextClassLoader().getResourceAsStream( filename );
            parser = f.createParser(stream);
        } catch ( IOException e ) {
            e.printStackTrace();
        }
    }

    public String getTable() throws Exception {
        try {
            StringBuilder builder = new StringBuilder();
            List<String> header = new ArrayList<>();
            if ( parser.nextToken() != JsonToken.START_ARRAY ) {
                throw new RuntimeException( "Expected an array of objects." );
            }
            while ( parser.nextToken().equals(JsonToken.START_OBJECT) ) {
                buildRow(header,builder);
            }
            if ( parser.currentToken() != JsonToken.END_ARRAY ) {
                throw new RuntimeException( "Expected end of JSON array, got: " + parser.currentToken() );
            }
            wrapRowsWithTable(header,builder);
            return builder.toString();
        } finally {
            parser.close();
        }
    }

    private void wrapRowsWithTable( List<String> columns, StringBuilder builder ) {
        StringBuilder header = new StringBuilder();
        header.append("<table><thead><tr>");
        for( String column : columns ) {
            header.append("<th>" + column + "</th>");
        }
        header.append("</tr></thead>");
        builder.insert(0,header.toString());
        builder.append("</table>");
    }

    private void buildRow( List<String> header, StringBuilder builder ) throws IOException {
        int index = 0;
        builder.append("<tr>");
        while(parser.nextToken() != JsonToken.END_OBJECT)
        switch( parser.currentToken() ) {
        case FIELD_NAME:
            if( header.size() > index ) {
                if( !header.get(index).equals( parser.getCurrentName() ) ) {
                    throw new RuntimeException( "Expected field: " + header.get(index) + ", found: " + parser.getCurrentName() );
                }
            } else {
                header.add(parser.getCurrentName());
            }
            index++;
            break;
        case VALUE_NULL:
        case VALUE_TRUE:
        case VALUE_FALSE:
        case VALUE_NUMBER_INT:
        case VALUE_NUMBER_FLOAT:
        case VALUE_STRING:
            builder.append("<td>" + parser.getText() + "</td>");
            break;
        case VALUE_EMBEDDED_OBJECT:
            throw new RuntimeException( "Expecting an array of objects with no nested objects." );
        default:
            throw new RuntimeException( "Unexpected token: " + parser.currentToken() );
        }
    }
}