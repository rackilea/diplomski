case 3: //Deleting
        out.print("type surname you want to delete: ");
        String toDelete = kb.next();
        int deletedIndex = -1;
        for (int ctrl = 0; ctrl < regCount; ctrl++) {
            if(deletedIndex >= 0) {
                int newCtrl = ctrl + 1;
                regName[ctrl] = (newCtrl < regCount) ? regName[newCtrl] : null;
            } else if (regName[ctrl].equalsIgnoreCase(toDelete)) {
                deletedIndex = ctrl;
                out.println("Record deleted : #" + deletedIndex);
                regCount--;
            }
        }
        out.print("\n");
        func = 0;
    break;