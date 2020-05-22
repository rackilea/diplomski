ArrayList<String> namelist = null;
        try {

             AssetManager am = activity.getAssets();
             InputStream is = am.open("city_name_list.txt");
             Scanner inStream = new Scanner(is);
             namelist = new ArrayList<String>();

            while(inStream.hasNextLine()){
                    namelist.add(inStream.nextLine());
            }
        } catch (IOException e) {

        }