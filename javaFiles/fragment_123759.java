while (res.next())
        {
                String message = res.getString("message");
                Gui.out.append(message + "\n");
                lastLine = res.getInt("id");
        }