while( (line = bufferedReader.readLine() ) != null)
    {
        y = 0;   //RESET y

        String values[] = line.split(",");  
        for(String str : values)
        {
            matrix[x][y] = str;
            y = y + 1;
        }
        x = x + 1;
    }