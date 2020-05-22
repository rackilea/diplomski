try(BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)))){
        String input = br.readLine();
        int count = 0;
        for(int i = 0; i < input.length()- 1; i++){
            if(isNumeric(input.charAt(i))){

                // replace the Sysout with your own logic
                   System.out.println(input.charAt(i));
                }
            }
        } catch (IOException ex){
            ex.printStackTrace();
        }