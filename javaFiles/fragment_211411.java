int[] force_l = null;
    int[] force_r = null;
    try {

        File file = new File("file_json_test_three.txt");
        Path path = file.toPath();
        List<String> strings = Files.readAllLines(path);
        //List<String> strings = FileUtils.readLines(file); can be used with common-io-2.4 library
        int count = 0;
        for (String s : strings) {
            //System.out.println(s);
            String[] integer_Strings = s.split(" ");
            //System.out.println(Arrays.deepToString(integer_Strings));
            if (count == 0) {
                force_l = new int[integer_Strings.length];
                for (int i = 0; i < integer_Strings.length; i++) {
                    force_l[i] = Integer.parseInt(integer_Strings[i]);
                }
                count++;
            } else if (count == 1) {
                force_r = new int[integer_Strings.length];
                for (int i = 0; i < integer_Strings.length; i++) {
                    force_r[i] = Integer.parseInt(integer_Strings[i]);
                }
            }

        }

        System.out.println(Arrays.toString(force_l));
        System.out.println(Arrays.toString(force_r));


    } catch (Exception e) {
        e.printStackTrace();
    }