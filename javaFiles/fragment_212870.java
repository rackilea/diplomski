import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Scanner;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class EnsureValidJSON {

  private static ObjectMapper objectMapper = new ObjectMapper();

  public static void main(String[] args) {
    if (args.length == 0) {
      System.err.println("You must pass at least one String to be validated.");
    } else {

      for (String arg : args) {
        System.out.println("input: " + arg);
        byte[] msg = arg.getBytes();
        try {
          msg = ensureMsgIsValidJson(msg);
        } catch (IOException e) {
          msg = "{\"Unknown\" : \"Unknown\"}".getBytes();
        }
        System.out.println("output: " + new String(msg));
      }
    }
  }

  private static boolean isJSONValid(byte[] msg) {
    return isJSONFormat(msg) && isJSONOneMessage(msg);
  }

  private static boolean isJSONFormat(byte[] msg) {
    boolean isValid = false;
    String rawString = new String(msg).trim();
    try (Scanner sc = new Scanner(rawString)) {
      objectMapper.readTree(msg);
      // If the value evaluates to a number, objectMapper.readTree will not throw an Exception, so check that here.
      if (sc.hasNextLong() || sc.hasNextDouble()) {
        String err = String.format("%s is an invalid JSON message because it is numeric.", rawString);
        System.out.println(err);
      } else {
        isValid = true;
      }
    } catch (IOException e) {
      String err = String.format("%s is an invalid JSON message. We will attempt to make the message valid JSON. Its key will be 'Unknown'.", rawString);
      System.out.println(err);
    }

    return isValid;
  }

  private static boolean isJSONOneMessage(byte[] msg) {
    boolean isValid = false;
    try {
      JsonParser parser = objectMapper.getFactory().createParser(msg);
      JsonToken token;
      // balance will increment with each opening curly bracket and decrement with each closing curly bracket. We'll use this to ensure that this is only one JSON message.
      int balance = 0;
      while ((token = parser.nextToken()) != null) {
        if (token.isStructStart()) {
          balance++;
        } else if (token.isStructEnd()) {
          balance--;
        }
        if (balance == 0) {
          break;
        }
      }
      isValid = parser.nextToken() == null;
    } catch (IOException e) {
      String err = String.format("'%s' is an invalid JSON message due to the following error: '%s'. We will attempt to make the message valid JSON. Its key will be 'Unknown'.", new String(msg),
          e.getMessage());
      System.out.println(err);
    }

    return isValid;
  }

  private static byte[] ensureMsgIsValidJson(byte[] msg) throws IOException {
    return isJSONValid(msg) ? msg : createValidJSON(msg);
  }

  private static byte[] createValidJSON(byte[] msg) throws IOException {
    JsonFactory factory = new JsonFactory();
    try (OutputStream out = new ByteArrayOutputStream()) {
      JsonGenerator generator = factory.createGenerator(out);
      generator.writeBinary(msg);

      JsonNodeFactory nodeFactory = new JsonNodeFactory(false);
      ObjectNode validated = nodeFactory.objectNode();
      objectMapper.writeTree(generator, validated);
      validated.put("Unknown", new String(msg));
      byte[] validatedBytes = objectMapper.writeValueAsBytes(validated);
      String message = String.format("Message(%s) was successfully converted to a valid JSON message: %s", new String(msg), new String(validatedBytes));
      System.out.println(message);
      return validatedBytes;
    }
  }

}