for (int i = 0; i < books.size(); i++)
    {
        if (books.get(i).getTitle().equals(title)) 
        {
            if(!books.get(i).isBorrowed())
                books.get(i).borrowed();
            else
            {
                //Inform user book already borrowed
            }
            break;
        }
    }