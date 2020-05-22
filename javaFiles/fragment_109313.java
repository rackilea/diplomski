package org.sample;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;

import java.util.HashMap;
import java.util.Random;

@State(Scope.Thread)
public class MyBenchmark {

    String DNA;

    public MyBenchmark() {
        DNA = buildRandomDNA(1000000);
    }

    static String letters = "ATGCatgc";

    public static String buildRandomDNA(int size) {
        StringBuilder builder = new StringBuilder(size);
        Random r = new Random();

        for (int i = 0; i < size; ++i) {
            builder.append(letters.charAt(r.nextInt(letters.length())));
        }

        return builder.toString();
    }

    @Benchmark
    public void benchExons1() {
        getExons1(DNA);
    }

    @Benchmark
    public void benchExons2() {
        getExons2(DNA);
    }

    @Benchmark
    public void benchExons3a() {
        getExons3a(DNA);
    }

    @Benchmark
    public void benchExons3b() {
        getExons3b(DNA);
    }

    @Benchmark
    public void benchExons4() {
        getExons4(DNA);
    }

    @Benchmark
    public void benchExons5() {
        getExons5(DNA);
    }

    @Benchmark
    public void benchExons6() {
        getExons6(DNA);
    }

    public static String getExons1(String sequence) {
        return sequence.replaceAll("[atgc]", "");
    }

    public static String getExons2(String sequence) {
        StringBuilder exonBuilder = new StringBuilder();

        for (int i = 0; i < sequence.length(); i++) {
            char c = sequence.charAt(i);
            if (c == 'A' || c == 'T' || c == 'G' || c == 'C')
                exonBuilder.append(c);
        }
        return exonBuilder.toString();
    }

    public static String getExons3a(String sequence) {
        StringBuilder exonBuilder = new StringBuilder();

        for (int i = 0; i < sequence.length(); i++) {
            char c = sequence.charAt(i);
            if (c <= 'Z') {
                exonBuilder.append((char) c);
            }
        }

        return exonBuilder.toString();
    }

    public static String getExons3b(String sequence1) {
        char[] sequence = sequence1.toCharArray();
        StringBuilder exonBuilder = new StringBuilder();

        for (int i = 0; i < sequence.length; i++) {
            if (sequence[i] <= 'Z') {
                exonBuilder.append(sequence[i]);
            }
        }

        return exonBuilder.toString();
    }

    public static HashMap<String, String> M = new HashMap<String, String>();

    public static void buildTable() {
        for (int a = 0; a < letters.length(); ++a) {
            for (int b = 0; b < letters.length(); ++b) {
                for (int c = 0; c < letters.length(); ++c) {
                    for (int d = 0; d < letters.length(); ++d) {
                        String key = "" + letters.charAt(a) + letters.charAt(b) + letters.charAt(c) + letters.charAt(d);
                        M.put(key, getExons1(key));
                    }
                }
            }
        }
    }

    public static String getExons4(String sequence1) {
        char[] sequence = sequence1.toCharArray();
        StringBuilder exonBuilder = new StringBuilder();

        for (int i = 0; i < sequence.length; i += 4) {
            exonBuilder.append(M.get(new String(sequence, i, 4)));
        }

        return exonBuilder.toString();
    }

    public static String getExons5(String sequence1) {
        char[] sequence = sequence1.toCharArray();
        int p = 0;

        for (int i = 0; i < sequence.length; i++) {
            if (sequence[i] <= 'Z') {
                sequence[p] = sequence[i];
                ++p;
            }
        }

        return new String(sequence, 0, p);
    }

    public static int dnatoint(char[] s, int start, int len) {
        int key = 0;
        for (; len > 0; len--, start++) {
            switch (s[start]) {
            case 'A': key = (key << 3) | 0; break;
            case 'C': key = (key << 3) | 1; break;
            case 'G': key = (key << 3) | 2; break;
            case 'T': key = (key << 3) | 3; break;
            case 'a': key = (key << 3) | 4; break;
            case 'c': key = (key << 3) | 5; break;
            case 'g': key = (key << 3) | 6; break;
            case 't': key = (key << 3) | 7; break;
            }
        }
        return key;
    }

    public static String[] M2 = new String[8*8*8*8];

    public static void buildTable2() {
        for (int a = 0; a < letters.length(); ++a) {
            for (int b = 0; b < letters.length(); ++b) {
                for (int c = 0; c < letters.length(); ++c) {
                    for (int d = 0; d < letters.length(); ++d) {
                        String key = "" + letters.charAt(a) + letters.charAt(b) + letters.charAt(c) + letters.charAt(d);
                        M2[dnatoint(key.toCharArray(), 0, 4)] = getExons1(key);
                    }
                }
            }
        }
    }

    public static String getExons6(String sequence1) {
        char[] sequence = sequence1.toCharArray();
        StringBuilder exonBuilder = new StringBuilder();

        assert (sequence.length % 4) == 0;

        for (int i = 0; i < sequence.length; i += 4) {
            exonBuilder.append(M2[dnatoint(sequence, i, 4)]);
        }

        return exonBuilder.toString();
    }

    static {
        buildTable();
        buildTable2();
    }

    //@Benchmark
    public void testMethod() {
        // This is a demo/sample template for building your JMH benchmarks. Edit as needed.
        // Put your benchmark code here.
    }

}