while(itr.hasNext()){
            Row nextRow = itr.next();
            // For each row, iterate through all the columns
            Iterator<Cell> cellIterator = nextRow.cellIterator();
            while (cellIterator.hasNext()) 
            {
               Cell cell = cellIterator.next();

                newName =  nextRow.getCell(0).toString();

                if(nextRow.getCell(1).toString().contains(",")){
                    StringTokenizer st = new StringTokenizer(nextRow.getCell(1).toString(),",");
                    while(st.hasMoreTokens()){
                        oldName = st.nextToken();
                    }
               }
                else{
                     oldName = nextRow.getCell(1).toString();
                    }
            }
            System.out.println();
        }