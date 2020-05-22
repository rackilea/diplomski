try {
                FileInputStream fis = new FileInputStream("conf/sampleprop.conf");
                Properties prop = new Properties();
                prop.load(fis);
                System.out.println(prop.getProperty("TEST"));
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }