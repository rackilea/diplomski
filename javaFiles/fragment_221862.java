while((line = in.readLine()) != null){
                                builder.append(line);
                                builder.append("\n");
                                index++; //increment the index to move the next one up for the next line

                                String temp[] = line.split(",");
                                c4 = Double.parseDouble(temp[3]);
                                c5 = Double.parseDouble(temp[4]);
                                c6 = Double.parseDouble(temp[5]);
                            }