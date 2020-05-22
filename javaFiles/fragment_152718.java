while((line=asd.readLine()) != null)
        {
            count++; //added now  ----> 1
            String var[] = line.split("-");
            names[j] = var[0];
            timeInd[j]=Double.parseDouble(var[1]);
            scores[j] = var[2];
            difficulty[j] = var[3];
            j++;
        }