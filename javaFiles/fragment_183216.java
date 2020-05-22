private static void sendMap()
    {
        System.out.println("Sending MAP");
        ArrayList<String> list =new ArrayList<String>();
        list.add("ABC");
        list.add("XYZ");
        list.add("ABXY");
        Map<String, Object> params=new HashMap<String, Object>();
        params.put("Type", "Document");
        params.put("bytes", getByteArray());
        params.put("NameList", list);

        try {
            URL url=  new URL(iinkiturl+"/getMap?id=1234567");
            URLConnection uc = url.openConnection();
            uc.setDoOutput(true);
            uc.setDoInput(true);
            uc.setAllowUserInteraction(false);

            DataOutputStream dstream = new DataOutputStream(uc.getOutputStream());

            dstream.write(new com.google.gson.Gson().toJson(params).getBytes());
            dstream.close();

             InputStream in = uc.getInputStream();
            int x;
            while ((x = in.read()) != -1) {
                System.out.write(x);
            }
            in.close();

            BufferedReader r = new BufferedReader(new InputStreamReader(in));
            StringBuffer buf = new StringBuffer();
            String line;
            while ((line = r.readLine()) != null) {
                buf.append(line);
            }


        } catch(Exception exception)
        {
            exception.printStackTrace();
        }


    }