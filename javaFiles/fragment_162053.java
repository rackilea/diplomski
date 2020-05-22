String line = null; //not declared within while loop
                int fieldIndex = 0;
                while (( line = input.readLine()) != null) {
                    System.out.println(line);//Print 
                    Command[fieldIndex].setText(line);
                    fieldIndex++
                    if (fieldIndex > 7) {
                        break;
                    }