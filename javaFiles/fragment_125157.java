for(int row = 0; row < readMapHeight; row++) {
            String line = br.readLine();
            if(line == null || line.isEmpty()) {
                System.out.println("Line is empty or null");
            } else {
                System.out.println(line);
                String[] tileValues = line.split(",");
                for(int col = 0; col < readMapWidth; col++){
                   map[row][col] = Integer.parseInt(tileValues[col]);  

            }
         }
        }