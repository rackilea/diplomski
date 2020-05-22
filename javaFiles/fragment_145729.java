try
    {
        String result = null;
        Process p = Runtime.getRuntime().exec("wmic baseboard get serialnumber");
        BufferedReader input
                = new BufferedReader(new InputStreamReader(p.getInputStream()));
        String line;
        while ((line = input.readLine()) != null)
        {
            result += line;
        }
        if (result.equalsIgnoreCase(" ")) {
            System.out.println("Result is empty");
        } else
        {
            motherboard.setText(result);
        }
        input.close();
    } catch (IOException ex)
    {
        Exceptions.printStackTrace(ex);
    }