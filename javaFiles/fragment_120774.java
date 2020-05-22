writer = new PrintWriter("printwriter3.txt", "UTF-8");
        // will write in the UTF-8 language to a file named printwriter.txt

        boolean exit = false;
        while (exit == false)
        {
            String user = input.nextLine();
            if (user.equals("end"))
            {
                exit = true;
            }
            else
            {
                writer.println(user);
                writer.flush();
            }

        }
        writer.close();