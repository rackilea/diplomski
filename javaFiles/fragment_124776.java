for (i=0; i<line.size(); i++){
                sSQL = sSQL + line.get(i); //add record per line in columns
                if(!(i+1==line.size()))
                {
                    str=str+",";
                }
            }