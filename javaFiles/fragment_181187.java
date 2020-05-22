enum ConfigProperties { prop1, prop2 }

class Test {
    public static void main(String[] args) {

        String[] line = { "prop1" };

        switch (ConfigProperties.valueOf(line[0].toLowerCase())) {
        case prop1: System.out.println("Property 1"); break;
        case prop2: System.out.println("Property 2"); break;
        }
    }
}