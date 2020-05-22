public class Test {

    public static void main(String[] args) {

        String input =
                "0000027788|001400000000000000000001224627|G1|        |         |G1\r\n" + 
                "0000027789|001400000000000000000001224627|D1|        |         |G1\r\n" + 
                "0000027790|001400000000000000000001224627|D1|        |         |G1\r\n" + 
                "0000027790|001400000000000000000001224627|D1|        |         |G1\r\n" + 
                "0000027791|001400000000000000000001224627|G2|        |         |G2\r\n" + 
                "0000027792|001400000000000000000001224627|D2|        |         |G2\r\n" + 
                "0000027793|001400000000000000000001224627|D2|        |         |G2\r\n" + 
                "0000027794|001400000000000000000001224627|G6|        |         |G6";

        String[] lines = input.split("\r\n");
        String[][] parts = new String[lines.length][];
        for (int i = 0; i < lines.length; i++)
            parts[i] = lines[i].split("\\|");

        String currG = "G1";
        String lastD = "";
        for (int i = 1; i < lines.length; i++) {
            if (parts[i][2].startsWith("G")) {
                System.out.println("Last D for " + currG + " is " + lastD + " at line " + (i-1));
                lines[i-1] += "   LL";
                currG = parts[i][2];
            }
            else
                lastD = parts[i][2];
        }

        System.out.println();
        for (int i = 0; i < lines.length; i++)
            System.out.println(lines[i]);
    }
}