char aChar = 'x';
                for (int i = 0; i <= line.length()-1; i++) 
                {
                    aChar = line.charAt(i);
                    lineFile += aChar;
                }

                words = lineFile.split(" ");
                if (line == null)
                    break;
                lineFile = "";