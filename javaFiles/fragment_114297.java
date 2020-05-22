File f = new File("Path_to_the_file");
    new Thread(new Runnable() {
        @Override
        public void run() {
            long l = f.lastModified();
            String s = "";
            while (true) {

                if (f.lastModified() == l) {
                    System.out.print();
                } else {
                    try {
                        Scanner sc = new Scanner(f);
                        s = "";
                        while (sc.hasNext()) {
                            s += sc.nextLine();
                            s += "\n";
                            jTextArea1.setText(s);
                        }
                        System.out.println(false);
                        l = f.lastModified();
                        sc.close();
                    } catch (FileNotFoundException ex) {
                        System.out.println(ex);
                    }
                }

            }
        }

    }).start();