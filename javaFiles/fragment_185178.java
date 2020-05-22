case 3: //Deleting
        out.print("type surname you want to delete: ");
        String toDelete = kb.next();
        int deleted = 0;
        for (int ctrl = 0; ctrl < regCount; ctrl++) {
            if (regName[ctrl].equalsIgnoreCase(toDelete)) {
                out.println("Record deleted.");
                deleted++;
            }
            if(deleted > 0) {
                int newCtrl = ctrl + deleted;
                regName[ctrl] = (newCtrl < regCount) ? regName[newCtrl] : null;
            }
        }
        regCount -= deleted;
        out.print("\n");
        func = 0;
    break;