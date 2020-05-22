BufferedReader bf = new BufferedReader (new FileReader (new File ("populationByProvinces.txt")));
        provinceList = new ArrayList ();
        year = new double [13] [5];
        String line = "";
        for (int x = 0 ; x <= 12 ; x++)
        {
            line = bf.readLine ();
            provinceList.add (line);

            for (int y = 0 ; y <= 4 ; y++)
            {
                year [x] [y] = Double.parseDouble ((line.substring ((y * 10 + 30), (y * 10 + 38))));
            }
        }
        bf.close ();