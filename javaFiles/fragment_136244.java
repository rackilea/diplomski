while(it.hasNext())
        {
            String sent=(String)it.next();
            System.out.println(sent);

            if (sent.indexOf("LISTENING") > 0) listening ++;
            if (sent.indexOf("TIME-WAIT") > 0) wait++;
            if (sent.indexOf("ESTABLISHED") > 0) established ++;

        }