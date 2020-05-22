package test;

import java.text.ParseException;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {

  private static final List<String> SAMPLE_INPUTS = Arrays.asList(
    "P1==1,P3==1233213213345",
    "P1==2,P2==123321512332456*",
    "P1==3,P2==123321451232123332*,P4==9512*",
    "P1==4,P3==312512343243234*,P4==98*,P5==453213264");

  public static void main(String... args) {
    //test(new StateMachineParser());
    //test(new RegexParser());
    //test(new SplitParser());
    benchmark(Arrays.asList(new SplitParser(), new RegexParser(), new StateMachineParser()));
  }

  private static void test(ReferenceDataParser parser) {
    for (String input : SAMPLE_INPUTS) {
      try {
        System.err.println(parser.parse(input));
      }
      catch(ParseException pe) {
        System.err.println("Failed to parse: " + input);
        int offset = pe.getErrorOffset();
        StringBuilder buf = new StringBuilder("                 ");
        for (int i = 0; i < offset; i++) {
          buf.append(' ');
        }
        buf.append('^');
        System.err.println(buf.toString());
        pe.printStackTrace();
      }
    }
  }


  private static void benchmark(List<ReferenceDataParser> parsers) {
    int warmupIters = 100 * 1000;
    int iters = 1000 * 1000;

    System.err.println("Warming up...");
    for (ReferenceDataParser parser : parsers) {
      try {
        for (String input : SAMPLE_INPUTS) {
          for (int i = 0; i < warmupIters; i++) {
            parser.parse(input);
          }
        }
      }
      catch(Exception e) {
        System.err.println("parser failed: " + parser.getClass().getSimpleName());
      }
    }

    System.err.println("Benchmarking...");
    for (ReferenceDataParser parser : parsers) {
      try {
        long start = System.nanoTime();
        for (String input : SAMPLE_INPUTS) {
          for (int i = 0; i < iters; i++) {
            parser.parse(input);
          }
        }
        long elapsed = System.nanoTime() - start;
        System.err.println(String.format("average parse time for %s: %.1fns",
          parser.getClass().getSimpleName(), elapsed / (double) (iters * SAMPLE_INPUTS.size())));
      }
      catch(Exception e) {
        System.err.println("parser failed: " + parser.getClass().getSimpleName());
      }
    }
  }

  public static interface ReferenceDataParser {

    public ReferenceData parse(String line) throws ParseException;

  }



  public static class ReferenceData {

    private final int p1;
    private final String p2;
    private final String p3;
    private final String p4;
    private final String p5;

    public ReferenceData(int p1, String p2, String p3, String p4, String p5) {
      this.p1 = p1;
      this.p2 = p2;
      this.p3 = p3;
      this.p4 = p4;
      this.p5 = p5;
    }

    public String toString() {
      return String.format("P1=%s,P2=%s,P3=%s,P4=%s,P5=%s", p1, p2, p3, p4, p5);
    }
  }


  private static class SplitParser implements ReferenceDataParser {

    public ReferenceData parse(String line) throws ParseException {
      int p1 = 0;
      String p2 = null;
      String p3 = null;
      String p4 = null;
      String p5 = null;

      String lineSplit[] = line.split(",");
      for(int i = 0; i < lineSplit.length; i++) {
        String value = lineSplit[i].split("==")[1];
        if(lineSplit[i].startsWith("P1")) {
          p1 = Integer.valueOf(value);
        }
        else if(lineSplit[i].startsWith("P2")) {
          p2 = value;
        }
        else if(lineSplit[i].startsWith("P3")) {
          p3 = value;
        }
        else if(lineSplit[i].startsWith("P4")) {
          p4 = value;
        }
        else if(lineSplit[i].startsWith("P5")) {
          p5 = value;
        }
      }

      return new ReferenceData(p1, p2, p3, p4, p5);
    }

  }

  private static class RegexParser implements ReferenceDataParser {

    private static Pattern p = Pattern.compile(
      "(?:P1==(\\d+))(?:\\s*,P2==([0-9*]+))?(?:\\s*,P3==([0-9*]+))?(?:\\s*,P4==([0-9*]+))?(?:\\s*,P5==([0-9*]+))?");

    public ReferenceData parse(String line) throws ParseException {
      Matcher m = p.matcher(line);
      if(!m.matches()) {
        throw new ParseException(line, 0);
      }
      int p1 = Integer.parseInt(m.group(1));
      String p2 = m.group(2);//note: this can be null is P2 is not part of the line
      String p3 = m.group(3);
      String p4 = m.group(4);
      String p5 = m.group(5);
      return new ReferenceData(p1, p2, p3, p4, p5);
    }

  }



  private static class StateMachineParser implements ReferenceDataParser {

    private static final int STATE_INITIAL_P = 0;
    private static final int STATE_P = 1;
    private static final int STATE_P_NUM = 2;
    private static final int STATE_EQ1 = 3;
    private static final int STATE_EQ2 = 4;
    private static final int STATE_VALUE = 5;

    public ReferenceData parse(String line) throws ParseException {
      int p1 = 0;
      String p2 = null;
      String p3 = null;
      String p4 = null;
      String p5 = null;

      int state = STATE_INITIAL_P;
      int length = line.length();
      int pNum = 0;
      int valueStart = 0;
      int valueEnd = 0;
      for (int i = 0; i < length; i++) {
        char c = line.charAt(i);
        switch(state) {
        case STATE_INITIAL_P:
        case STATE_P:
          if (c != 'P') {
            throw new ParseException(line, i);
          }
          state = STATE_P_NUM;
          break;
        case STATE_P_NUM:
          if (c < '1' || c > '5') {
            throw new ParseException(line, i);
          }
          pNum = c - '0';
          state = STATE_EQ1;
          break;
        case STATE_EQ1:
          if (c != '=') {
            throw new ParseException(line, i);
          }
          state = STATE_EQ2;
          break;
        case STATE_EQ2:
          if (c != '=') {
            throw new ParseException(line, i);
          }
          valueStart = valueEnd = i + 1;
          state = STATE_VALUE;
          break;
        case STATE_VALUE:
          if ((c >= '0' && c <= '9') || c == '*') {
            valueEnd++;
          }
          else if (c == ',') {
            if (valueStart == valueEnd) {
              throw new ParseException(line, i);
            }
            switch(pNum) {
            case 1:
              if (p1 != 0) {
                throw new ParseException(line, i);
              }
              p1 = Integer.parseInt(line.substring(valueStart, valueEnd));
              break;
            case 2:
              if (p2 != null) {
                throw new ParseException(line, i);
              }
              p2 = line.substring(valueStart, valueEnd);
              break;
            case 3:
              if (p3 != null) {
                throw new ParseException(line, i);
              }
              p3 = line.substring(valueStart, valueEnd);
              break;
            case 4:
              if (p4 != null) {
                throw new ParseException(line, i);
              }
              p4 = line.substring(valueStart, valueEnd);
              break;
            case 5:
              if (p5 != null) {
                throw new ParseException(line, i);
              }
              p5 = line.substring(valueStart, valueEnd);
              break;
            default:
              // illegal P-number
              throw new ParseException(line, i);
            }
            state = STATE_P;
          }
          break;
        }
      }
      switch(state) {
      case STATE_INITIAL_P:
      case STATE_P:
      case STATE_P_NUM:
      case STATE_EQ1:
      case STATE_EQ2:
        // invalid end-states
        throw new ParseException(line, length);
      case STATE_VALUE:
        // valid end-state; finish with last parsed value
        if (valueStart == valueEnd) {
          throw new ParseException(line, length);
        }
        switch(pNum) {
        case 1:
          if (p1 != 0) {
            throw new ParseException(line, length);
          }
          p1 = Integer.parseInt(line.substring(valueStart, valueEnd));
          break;
        case 2:
          if (p2 != null) {
            throw new ParseException(line, length);
          }
          p2 = line.substring(valueStart, valueEnd);
          break;
        case 3:
          if (p3 != null) {
            throw new ParseException(line, length);
          }
          p3 = line.substring(valueStart, valueEnd);
          break;
        case 4:
          if (p4 != null) {
            throw new ParseException(line, length);
          }
          p4 = line.substring(valueStart, valueEnd);
          break;
        case 5:
          if (p5 != null) {
            throw new ParseException(line, length);
          }
          p5 = line.substring(valueStart, valueEnd);
          break;
        default:
          // illegal P-number
          throw new ParseException(line, length);
        }
        break;
      default:
        throw new RuntimeException("unknown state: " + state);
      }
      return new ReferenceData(p1, p2, p3, p4, p5);
    }

  }


}