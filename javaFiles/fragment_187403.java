try (PrintWriter pw = new PrintWriter( new FileOutputStream(new File(outputFile), true))) {

            int count = 0;
            String temp="";
            for (String frase : frasi) {
                pw.print(frase + ". ");
                if(count==0)
                temp=(frasi.length-count)+"";
                else
                 temp=temp+","+(frasi.length-count);
                count++;
            }
            pw.print("\n" + temp);
            pw.close();

        } catch (IOException e) {
            //System.out.println("Error writing into the outputFile: " + outputFile);
            e.printStackTrace();
        }