package treereader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.io.Reader;

enum Token { LPAREN, RPAREN, NUMBER, EOF, ERROR };

class Scanner {

    final Reader in;
    final char [] buf = new char[1];
    final StringBuilder token = new StringBuilder();

    private static final char EOF_MARK = Character.MIN_VALUE;

    Scanner(Reader in) {
        this.in = in;
        read();
    }

    final void read() {
        try {
            if (in.read(buf) < 1) {
                buf[0] = EOF_MARK;
            }
        } catch (IOException ex) {
            System.err.println("i/o error");
            buf[0] = EOF_MARK;
        }
    }

    Token getNext() {
        while (Character.isWhitespace(buf[0])) {
            read();
        }
        if (Character.isDigit(buf[0])) {
            token.setLength(0);
            do {
                token.append(buf[0]);
                read();
            } while (Character.isDigit(buf[0]));
            return Token.NUMBER;
        }
        if (buf[0] == '(') {
            read();
            return Token.LPAREN;
        }
        if (buf[0] == ')') {
            read();
            return Token.RPAREN;
        }
        if (buf[0] == EOF_MARK) {
            return Token.EOF;
        }
        return Token.ERROR;
    }

    String getString() {
        return token.toString();
    }
}

class Node {
    public void print(PrintStream out) {
        out.print("()");
    }
}

class UnaryNode extends Node {

    int val;

    public UnaryNode(int val) {
        this.val = val;
    }

    @Override
    public void print(PrintStream out) {
        out.print("(" + val + ")");
   }
}

class BinaryNode extends Node {

    int val;
    Node left, right;

    public BinaryNode(int val, Node left, Node right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    @Override
    public void print(PrintStream out) {
        out.print("(" + val + " ");
        left.print(out);
        out.print(' ');
        right.print(out);
        out.print(')');
    }
}

class Parser {

    final Scanner scanner;
    Token lookAhead;

    Parser(Reader in) {
        scanner = new Scanner(in);
        lookAhead = scanner.getNext();
    }

    void advance() {
        lookAhead = scanner.getNext();
    }

    void match(Token token) throws IOException {
        if (lookAhead == token) {
            advance();
        } else {
            throw new IOException("Expected " + token + ", found " + lookAhead);
        }
    }

    Node parse() throws IOException {
        Node tree;
        match(Token.LPAREN);
        if (lookAhead == Token.NUMBER) {
            int val = Integer.valueOf(scanner.getString());
            advance();
            if (lookAhead == Token.LPAREN) {
                Node left = parse();
                Node right = parse();
                tree = new BinaryNode(val, left, right);
            } else {
                tree = new UnaryNode(val);
            }
        } else {
            tree = new Node();
        }
        match(Token.RPAREN);
        return tree;
    }
}

public class TreeReader {

    public static void main(String[] args) {
        try {
            Parser parser = new Parser(new BufferedReader(new FileReader(new File(args[0]))));
            Node tree = parser.parse();
            tree.print(System.out);
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
    }    
}