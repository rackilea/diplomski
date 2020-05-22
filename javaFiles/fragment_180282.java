Properties p1 = new Properties();
            InputStream is1 = new FileInputStream("File.txt");
            p1.load(is1);
            PrintWriter pw1 = new PrintWriter(System.out);
            System.out.println("printing property values");
            p1.list(pw1);
            System.out.println(p1.getProperty("1"));
            System.out.println(p1.getProperty("2"));