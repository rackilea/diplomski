try
            {
                FileInputStream fstream = new FileInputStream("c:/Test/userInfo.txt");
                // Use DataInputStream to read binary NOT text.
                BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
                String strLine;
                int count = 0;

                count++;

                while((strLine = br.readLine())!= null)
                {
                    //Enter userName
                    WebElement userName = driver.findElement(By.id("username"));
                    userName.clear();
                    userName.sendKeys(strLine);
                    System.out.println(strLine);

                    strLine = br.readLine();
                    count++;
                    //Enter Password
                    WebElement password = driver.findElement(By.id("pword"));
                    password.clear();
                    password.sendKeys(strLine);
                    System.out.println(strLine);
                }
                in.close();
                br.close();
            }
            catch (Exception e)
            {
                System.err.println("Error: " + e.getMessage());
            }

    }