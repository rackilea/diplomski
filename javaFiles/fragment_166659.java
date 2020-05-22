import java.util.*;

public class Main {   
    public static void main(String[] args) {
        int n = 1;
        for(String combination : new CombinationIterator("ben")) {
            System.out.println((n++)+" = "+combination);
        }
        System.out.println("-------------");
        n = 1;
        for(String combination : new CombinationIterator("test?", "TEST!")) {
            System.out.println((n++)+" = "+combination);
        }
    }
}

class CombinationIterator implements Iterator<String>, Iterable<String> {

    protected final String zeros;
    protected final String ones;
    private int current;

    public CombinationIterator(String word) {
        this(word.toLowerCase(), word.toUpperCase());
    }

    public CombinationIterator(String zeros, String ones) {
        this.zeros = zeros;
        this.ones = ones;
        this.current = 0;
    }

    @Override
    public boolean hasNext() {
        return current < (int)Math.pow(2, zeros.length());
    }

    @Override
    public Iterator<String> iterator() {
        return this;
    }

    @Override
    public String next() {
        if(!hasNext()) {
            throw new NoSuchElementException("No such combintion: "+current+" in '"+zeros+"'");
        }
        char[] chars = zeros.toCharArray();
        for(int i = zeros.length()-1, bit = 1; i >= 0; i--, bit <<= 1) {
            if((bit & current) != 0) {
                chars[i] = ones.charAt(i);
            }
        }
        current++;
        return new String(chars);
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }
}