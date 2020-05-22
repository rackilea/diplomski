while((line = br.readLine()) != null) {
            if ("end".equals(line.trim())) {
                 allColors.add(color);
                 color = new ArrayList<HashMap<String,String>>();
            }
            else {
            String[] tokens = line.split(" ");
            String color = tokens[0];
            String colorValue = tokens[1];
            HashMap<String,String> colorWithValue = new HashMap<String,String>();
            colorWithValue.put(color, colorValue);

            color.add(colorWithValue);
            }
        }
        br.close();