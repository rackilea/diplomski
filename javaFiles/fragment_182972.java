while (inputStream.hasNext());
        {
            line = inputStream.nextLine();
            firstWeight = inputStream.nextDouble();
            while (inputStream.hasNextInt()) 
            {
                        sum += inputStream.nextInt();
                count ++;
                avg = (sum/count);
                }
            lastWeight = inputStream.nextDouble();
                    outputStream.println(line + " " + firstWeight + " " + sum + " " + count + " " +  lastWeight + " " + avg + " " + (lastWeight-firstWeight));
        }