while ((line = read.readLine()) != null){
        if(line.trim().equals("")){
            break;
        }
        hold = hold.concat(line);
    }