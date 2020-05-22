try
        {
            File fileCI = new File ( "CI.txt" );
            FileWriter fileWriter = new FileWriter ( fileCI );
            BufferedWriter bw = new BufferedWriter ( fileWriter );

            for ( Customer ci : custList )
            {
                if ( inputUser.equals ( ci.getUserName () )
                        && inputPass.equals ( ci.getPassword () ) )
                {
                    ci.setCardNo ( newCardNo );
                    ci.setCardType ( newCardType );
                }
                String text = ci.getRealName () + ";" + ci.getUserName () + ";"
                        + ci.getPassword () + ";" + ci.getContact () + ";"
                        + ci.getcardType () + ";" + ci.getcardNo ();

                bw.write ( text );

            }
bw.close ();
fileWriter.close();

        }
        catch ( FileNotFoundException e )
        {
            System.out.println ( "File not found" );
        }
        catch ( IOException e )
        {
            System.out.println ( "Unable to write to file" );
        }