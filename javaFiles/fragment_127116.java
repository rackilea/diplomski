package org.json;

import java.io.IOException;
import java.io.Writer;
import java.util.Iterator;

public class JSONArrayIndent extends JSONArray {

    @Override
    public Writer write(Writer writer, int indentFactor, int indent) throws JSONException {
        try {
            boolean commanate = false;
            int length = this.length();
            writer.write('[');

            if (length > 0) {
                final int newindent = indent + indentFactor;

                Iterator<Object> iterator = iterator();
                while (iterator.hasNext()) {
                    Object next = iterator.next();
                    if (commanate) {
                        writer.write(',');
                    }
                    if (indentFactor > 0) {
                        writer.write('\n');
                    }
                    JSONObject.indent(writer, newindent);
                    try {
                        JSONObject.writeValue(writer, next,
                            indentFactor, newindent);
                    } catch (Exception e) {
                        throw new JSONException("Unable to write JSONArray value: " + next, e);
                    }
                    commanate = true;
                }
                if (indentFactor > 0) {
                    writer.write('\n');
                }
                JSONObject.indent(writer, indent);
            }
            writer.write(']');
            return writer;
        } catch (IOException e) {
            throw new JSONException(e);
        }
    }
}