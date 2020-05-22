package de.scrum_master.stackoverflow;

import java.util.BitSet;

public class ASCIIConverter {
  public byte[] compress(String message) {
    BitSet bits = new BitSet(message.length() * 7);
    int currentBit = 0;
    for (char character : message.toCharArray()) {
      for (int bitInCharacter = 0; bitInCharacter < 7; bitInCharacter++) {
        if ((character & 1 << bitInCharacter) > 0)
          bits.set(currentBit);
        currentBit++;
      }
    }
    return bits.toByteArray();
  }

  public String decompress(byte[] compressedMessage) {
    BitSet bits = BitSet.valueOf(compressedMessage);
    int numBits = 8 * compressedMessage.length - compressedMessage.length % 7;
    StringBuilder decompressedMessage = new StringBuilder(numBits / 7);
    for (int currentBit = 0; currentBit < numBits; currentBit += 7) {
      char character = (char) bits.get(currentBit, currentBit + 7).toByteArray()[0];
      decompressedMessage.append(character);
    }
    return decompressedMessage.toString();
  }

  public static void main(String[] args) {
    String[] messages = {
      "Hello world!",
      "This is my message.\n\tAnd this is indented!",
      " !\"#$%&'()*+,-./0123456789:;<=>?\n"
        + "@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_\n"
        + "`abcdefghijklmnopqrstuvwxyz{|}~",
      "1234567890123456789012345678901234567890"
        + "1234567890123456789012345678901234567890"
        + "1234567890123456789012345678901234567890"
        + "1234567890123456789012345678901234567890"
    };

    ASCIIConverter asciiConverter = new ASCIIConverter();
    for (String message : messages) {
      System.out.println(message);
      System.out.println("--------------------------------");
      byte[] compressedMessage = asciiConverter.compress(message);
      System.out.println("Number of ASCII characters = " + message.length());
      System.out.println("Number of compressed bytes = " + compressedMessage.length);
      System.out.println("--------------------------------");
      System.out.println(asciiConverter.decompress(compressedMessage));
      System.out.println("\n");
    }
  }
}