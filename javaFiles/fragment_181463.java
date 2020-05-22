try {
            BufferedReader sc = new BufferedReader(new FileReader("input2.txt"));

            ArrayList<String> name = new ArrayList<>();
            ArrayList<String> id = new ArrayList<>();
            ArrayList<String> place = new ArrayList<>();
            ArrayList<String> details = new ArrayList<>();

            String line = null;
            while ((line = sc.readLine()) !=null) {
                if (!line.trim().equals("")) {
                    System.out.println(line);
                    if (line.toLowerCase().contains("name")) {
                        name.add(line.split("=")[1].trim());
                    }
                    if (line.toLowerCase().contains("id")) {
                        id.add(line.split("=")[1].trim());
                    }
                    if (line.toLowerCase().contains("location")) {
                        place.add(line.split("=")[1].trim());
                    }
                    if (line.toLowerCase().contains("details")) {
                        details.add(line.split("=")[1].trim());
                    }
                }
            }

            PrintWriter pr = new PrintWriter(new File("out.csv"));
            pr.println("name;id;Place;Details;");
            for (int i = 0; i < name.size(); i++) {
                pr.println(name.get(i) + ";" + id.get(i) + ";" + place.get(i) + ";" + details.get(i) + ";");
            }
            pr.close();
        } catch (Exception e) {
            e.printStackTrace();
        }