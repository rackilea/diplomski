StringBuilder sb = new StringBuilder();

        while(in.hasNextLine()){
                    String line =in.nextLine();
                    sb.append(line).append("\n");
                    //System.out.println (line);

            }

        jtextArea.setText(sb.toString());