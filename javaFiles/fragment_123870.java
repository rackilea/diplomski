if (arg.contains(fileentry.getName())) {
            ta.append("\n" + fileentry.getName());
            arg.add(fileentry.getName());
            searchDirectory(folder, find, ta, arg);
            System.out.println(fileentry.getName()); // Testing purposes only
        } else {
            return;
        }