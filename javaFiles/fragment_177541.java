String[] filenames1 = statements.list(only);//only is filenamefilter
        int count = 0;
        for (int k = 0; k < filenames1.length; k++) {
            try {
                FileInputStream fs = new FileInputStream("C:/statements/" + filenames1[k]);
                System.out.println(filenames1[k]);
                BufferedReader br = new BufferedReader(new InputStreamReader(fs));
                FileOutputStream fos = new FileOutputStream("C:/ABC Statements/Statement" + count + ".RPT");
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
                while ((lines = br.readLine()) != null) {
                    String mine = lines.trim();
                    if (mine.startsWith("********END OF STATEMENT********")) {
                        bw.close();
                        fos.close();
                        count++;
                        fos = new FileOutputStream("C:/ABC Statements/Statement" + count + ".RPT");
                        bw = new BufferedWriter(new OutputStreamWriter(fos));
                        continue;
                    }
                    if (mine.isEmpty()) {
                        continue;
                    }
                    bw.write(lines);
                    bw.newLine();
                    bw.flush();
                }

                fs.close();
                br.close();
                fos.close();
                bw.close();
            } catch (Exception e) {
                System.out.println("Exception: " + e);
            }
        }