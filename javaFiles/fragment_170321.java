while (internalFile.exists()) {

            files.add(counter, internalFile);

            try {
                FileInputStream fis = new FileInputStream(internalFile);
                DataInputStream in = new DataInputStream(fis);
                BufferedReader br = new BufferedReader(new InputStreamReader(in));

                String strLine;

                while ((strLine = br.readLine()) != null) {
                    myData = myData + strLine;
                }
            }catch(IOException e){
                e.printStackTrace();
            }

                try {
                    jsonObject = new JSONObject(myData);

                    String assessmentDate = jsonObject.getString("assessmentDate");
                    String orchard = jsonObject.getString("orchard");

                    data.add(counter, assessmentDate + " : " + orchard);
                }catch(JSONException e){
                    e.printStackTrace();
                }

                counter++;
                fileNameNumber++;
                myData = "";


            filename = "newAssessment(" + fileNameNumber + ").json";

            internalFile = new File(directory, filename);
        }

        LVAssessments.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, data));