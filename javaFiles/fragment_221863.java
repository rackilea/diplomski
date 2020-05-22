double c4avg=0, c5avg=0, c6avg=0;

 while((line = in.readLine()) != null){
                                builder.append(line);
                                builder.append("\n");
                                index++; //increment the index to move the next one up for the next line

                                String temp[] = line.split(",");
//Calculate Running Sum stored in AVG variable
                                    c4avg += Double.parseDouble(temp[3]);
                                    c5avg += Double.parseDouble(temp[4]);
                                    c6avg += Double.parseDouble(temp[5]);
                                }
//Divide by total rows to get average
    c4avg/=index;
    c5avg/=index;
    c6avg/=index;