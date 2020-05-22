import java.io.*;
import java.util.*;

public class PolynomialAddition {
    static File dataInpt;
    static Scanner inFile;

    public static void main(String[] args) throws IOException {
        dataInpt = new File("/tmp/input.txt");
        inFile = new Scanner(dataInpt);

        while (inFile.hasNextLine()) {
            Node first = readPolynomial();
//          printList(first);

            Node second = readPolynomial();
//          printList(second);

            Node addition = addPolynomials(first, second);
//          printList(addition);

            printTabulated(first, second, addition);

            System.out.println("\n");
        }
    }

    private static Node addPolynomials(Node first, Node second) {
        Node head = null, current = null;
        while (null!=first || null!=second)
        {
            boolean pickfirst = false;
            boolean haveBoth = (null!=first && null!=second);

            Node node;
            if (haveBoth && first.exponent == second.exponent)
            {
                node = new Node(first.factor + second.factor, first.exponent, null);
                first = first.next;
                second = second.next;
            } else
            {
                pickfirst = first!=null && 
                    ((second == null) || first.exponent > second.exponent);

                if (pickfirst)
                {
                    node = new Node(first.factor, first.exponent, null);
                    first = first.next;
                } else
                {
                    node = new Node(second.factor, second.exponent, null);
                    second = second.next;
                }
            }

            if (current == null)
            {
                head = node;
                current = head;
            } else
            {
                current.next = node;
                current = node;
            }
        }

        return head;
    }

    private static void printTabulated(Node first, Node second, Node addition) {
        String line1="", line2="", barline="", line3="";
        while (addition != null)
        {
            String 
                 part1 = "           ", 
                 part2 = "           ", 
                 part3 = "           ";

            if (null!=first && first.exponent == addition.exponent) 
            {
                part1 = first.toString();
                first = first.next;
            } 
            if (null!=second && second.exponent == addition.exponent) 
            {
                part2 = second.toString();
                second = second.next;
            }
            part3 = addition.toString();
            addition = addition.next;

            line1 += part1;
            line2 += part2;
            barline += "-----------";
            line3 += part3;
        }

        System.out.println(line1);
        System.out.println(line2);
        System.out.println(barline);
        System.out.println(line3);
    }

    private static Node readPolynomial() {
        String line = inFile.nextLine();
        StringTokenizer myTokens = new StringTokenizer(line);

        Node head = null, previous = null;
        while (myTokens.hasMoreTokens()) {
            Node current = new Node();
            String term = myTokens.nextToken();

            if (term.startsWith("+"))
                term = term.substring(1);

            current.factor = Integer.parseInt(
                    term.substring(0, term.indexOf("x")));
            current.exponent = Integer.parseInt(
                    term.substring(term.indexOf("^") + 1));

            if (previous == null)
            {
                head = current;
                previous = head;
            } else
            {
                previous.next = current;
                previous = current;
            }
        }
        return head;
    }

    private static void printList(Node head) {
        for (Node ptr = head; ptr != null; ptr = ptr.next)
            System.out.print(ptr);
        System.out.println();
    }
}