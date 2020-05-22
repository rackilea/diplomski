int count = 0;
    while (count < n) {
        if (input.hasNextLine()) {
            output.println(input.nextLine()); // this is where i don't know what to place
            count++;
        }else
        {
            break;
        }

    }

    /**
     * Close scanner 
     */

    input.close();
    console.close();
    output.close();