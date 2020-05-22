public static void main(String[] args) {
            System.out.println("reading property file " + args[0]);

            // create new initial properties
            Properties properties = new Properties();
            // open reader to read the properties file
            try (FileReader in = new FileReader(args[0])){
                // load the properties from that reader
                properties.load(in);
            } catch (IOException e) {
                // handle the exception
                e.printStackTrace();
            }

            // print out what you just read
            Enumeration<?> propertyNames = properties.propertyNames();
            while(propertyNames.hasMoreElements()) {
                String name = propertyNames.nextElement().toString();
                System.out.println(name + ": " + properties.getProperty(name));
            }
        }