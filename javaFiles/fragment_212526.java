boolean done = false;
    // Loop runs as long as done != true
    while (!done) {
        line = sc.nextLine();   // Store data gathered from file into String
        String [] tokens = line.split(" "); // Split the string using space as delimiter

        // Switch for processing commands received
        switch (tokens[0]) {

        // Print name followed by newline
        case "N": {
                System.out.println("Evan Clay Bechtol");
                break;
            }

        // Create a memory object of size s
        case "C": {
                memory = new Memory(Integer.parseInt(tokens[1])); // Create a new Memory object
                break;
            }

        // End of data file, print newline and exit
        case "E": {
                System.out.println();
                done = true;    // Break the loop, end the program
                break;
            }

        // Add segment of size 'u' and lifetime 'v' and print confirmation record
        case "A": {
                int size = Integer.parseInt(tokens[1]);
                int lifeTime = Integer.parseInt(tokens[2]);
                timeOfDay++;

                memory.removeSegmentsDueToDepart(timeOfDay);

                // Boolean controls whether confirmation is printed.
                while (!memory.place(size, timeOfDay, lifeTime, true)) {
                    timeOfDay++;
                    memory.removeSegmentsDueToDepart(timeOfDay);
                    } // End while
                placements++;

                // Print confirmation message
                //System.out.println("Added segment of size: " + size + "\t" + "lifeTime: " + lifeTime + "\t" + "Time of Departure: " + (lifeTime + timeOfDay));
                break;  
            }

        // Print the current segments in the list
        case "P": {
                System.out.println ();
                memory.printLayout();
                //System.out.println ("End at time: " + timeOfDay);
                break;
            }

        case "R": {
                int size = Integer.parseInt(tokens[1]); // Size
                memory = new Memory(size);
                int minSegSize = Integer.parseInt(tokens[2]);   // Minimum seg. size
                int maxSegSize = Integer.parseInt(tokens[3]);   // Maximum seg. size
                int maxLifeTime = Integer.parseInt(tokens[4]);  // Maximum lifetime of segs.
                int numSegs = Integer.parseInt(tokens[5]);      // Number of segs. to simulate
                timeOfDay = 0;
                placements = 0;
                Random ran = new Random (); // "Random" number generator

                while (placements < numSegs) {
                    timeOfDay++;
                    memory.removeSegmentsDueToDepart(timeOfDay);
                    int newSegSize = minSegSize + ran.nextInt(maxSegSize - minSegSize + 1);
                    int newSegLifetime = 1 + ran.nextInt(maxLifeTime);
                    totalSpaceTime += newSegSize * newSegLifetime;

                    while (!memory.place(newSegSize, timeOfDay, newSegLifetime, false)) {
                        timeOfDay++;
                        memory.removeSegmentsDueToDepart(timeOfDay);
                    } // End while
                    placements++;
                } // End while

                // Print final summary of execution
                meanOccupancy = totalSpaceTime / (timeOfDay);
                System.out.printf ("Number of placements made =  %6d", placements);
                System.out.println();
                System.out.printf ("Mean occupancy of memory  = %8.2f", meanOccupancy);
                System.out.println();
            }
        } // End switch
    } // End while
    sc.close();