try
            {
                String input = "";
                br = new BufferedReader(new FileReader(inputFile));
                out = new PrintWriter(outputFile);
                while ((input = br.readLine()) != null)
                {
                    if (input.contains("you"))
                    {
                        input = input.replaceAll("you", "we");

                        out.println(input);
                    }
                }
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
            finally
            {
                try
                {
                    if (br != null)
                    {
                        br.close();
                    }
                    if (out != null)
                    {
                        out.close();
                    }
                }
                catch (IOException ex)
                {
                    ex.printStackTrace();


}
        }