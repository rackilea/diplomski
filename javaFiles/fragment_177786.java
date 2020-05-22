int i;
    for ( i = 0; i < books.size(); i++)
    {
        Book temp = books.get(i);
        books.remove(i);
        bool added = false;
        for (int j = 0; j < books.size(); j++) {
            if (books.get(j).compareTo(temp) > 0) {
                books.add(j, temp);
                added = true;
                break;
            }
        }
        if (!added) {
            books.add(temp);
        }
    }