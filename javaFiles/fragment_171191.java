final String regex = "[^a-zA-Z0-9_.-]|(?<!\\d)\\.(?!\\d)|(?<!\\w)-(?!\\w)";
final String string = "THE - . SOCIAL IMPACT OF THE CHERNOBYL DISASTER BY DAVID R. MARPLES "
        + "(ST. MARTIN'S PRESS: $35, CLOTH; $14.95, PAPER; 316 PP., ILLUSTRATED; 0-312-02432-0)\n\n\n";

String result=string.replaceAll(regex," ");
System.out.println(result);