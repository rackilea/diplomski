case 2: //Searching
        out.print("Enter keyword: ");
        String search = kb.next();
        boolean found = false;
        int searchCount = 0;
        for (int ctrl = 0; ctrl < regCount; ctrl++) {
            if (regName[ctrl].equalsIgnoreCase(search)) {
                found = true;
                out.println(search + " has a match : #" + ctrl);
                break;
            }
        }
        if(!found) {
            out.println(search + " has not found.");
        }
        out.print("\n");
        func = 0;
    break;