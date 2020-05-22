while((oneL = rdr.readLine()) != null){
                String[] line =oneL.split("\\.");
                blocks=new String[line.length][line.length];
            for(int i = 0; i < line.length;i++){
                blocks[i][linecount] = line[i];
                System.out.println(line[i]);

            }
            ++linecount;
        }