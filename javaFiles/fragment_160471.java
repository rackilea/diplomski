try (PrintWriter writer = new PrintWriter(new File("test.csv"))) {

        StringBuilder sb = new StringBuilder();
        String str = "1 cup, honey, 2 tablespoons ,canola";
        String []splitted_str=str.split(",");
        for (String string : splitted_str) {
            sb.append(string).append("\n"); //this will add a new line after every value separated by comma.
        }
        writer.write(sb.toString());

        System.out.println("done!");

    } catch (FileNotFoundException e) {
        System.out.println(e.getMessage());
    }