while(line != null) {
                    //Getting the address to place the value in
                    position = hash(line.toCharArray(), (int)tSize);

                    //If there is something there we enter the if statement
                    if(hashTable[position][0] != null) {

                        //Go to the end of the chain
                        while(hashTable[position][1].compareTo("-1") != 0)
                            position = Integer.parseInt(hashTable[position][1]);

                        //Save the position of the end of the chain
                        prevPosition = position;

                        //while we haven't found a spot and i < tableSize we update the last position we were at and move through the array
                        for(int i = 1; i < (int)tSize && hashTable[position][0] != null; i++) {
                            //we add +i to the original position and modulo the table size allowing wrap around in the array
                            position = (position+i)%(int)tSize;
                            System.out.println("Position: " + position);
                        }

                        //finally when we found a spot we update the previous position to link to the new item
                        hashTable[prevPosition][1] = Integer.toString(position);
                    }

                    //Adding the values to the hash table and setting the link to -1
                    hashTable[position][0] = new String(line);
                    hashTable[position][1] = new String(Integer.toString(-1));

                    line = reader.readLine();
                }