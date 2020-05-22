public static void main(String[] args) throws Exception
{
        int botKilledCount = 0, flagPickedUpCount = 0;
        String line, botLiteral = "***BOT_KILLED***", flagLiteral = "***FLAG_PICKEDUP***";
        BufferedReader reader = new BufferedReader(new FileReader(new File("!!YOUR FILE HERE!!")));
        while ((line = reader.readLine()) != null)
            for (String s : line.split(";"))
                if (s.equals(botLiteral))
                    botKilledCount++;
                else if (s.equals(flagLiteral))
                    flagPickedUpCount++;

        System.out.println("Bot Killed Count: " + botKilledCount + ", Flag Pickup Count: " + flagPickedUpCount);
}