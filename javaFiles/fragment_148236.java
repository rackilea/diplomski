Table root = new Table();
    Stack stack = new Stack();

    Table imageTable = new Table();
    //do stuff with table.

    Table buttonTable = new Table();
    //do stuff with button table

    stack.add(imageTable);
    stack.add(buttonTable); //button table will be placed exactly above imageTable

    root.add(stack);
    //do whatever you wanna do now with the root like adding on stage.