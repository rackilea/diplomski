File f = new File("D:\\test.txt");
        File f1 = new File("D:\\test.out");
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String s = "test";
        BufferedReader br = new BufferedReader(new FileReader(f));
        PrintWriter pr = new PrintWriter(f1);
        String line;
        while((line = br.readLine()) != null){
            if(line.contains(s)){
                System.out.println(line + " is found already");

                System.out.println("would you like to rewrite new data?");
                String go = input.readLine();
                if(go.equals("yes")){
                    System.out.println("Enter new Text :");
                    String newText = input.readLine();
                    line = line.replace(s, newText);
                }
            }

            pr.println(line);
        }
        br.close();
        pr.close();
        input.close();
        Files.move(f1.toPath(), f.toPath(), StandardCopyOption.REPLACE_EXISTING);