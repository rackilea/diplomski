System.out.println("Please type the item to add to the To-Do List"); // Output
    while (true) { // Continue adding items until user just hits enter
        String newItem = buf.readLine(); // read user input
        if (newItem == null || newItem.isEmpty()) { // check if the user entered anything, or just hit enter
            break; // If they didn't enter anything, then break the loop and drop out of the function
        }
        toDoList.add(newItem); // if they did enter something, add it to your to-do list

    }