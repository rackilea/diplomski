listDescItems = new ArrayList<String>();
        String items = loadFile(PATH + "/" + "items.txt");
        String[] sec = items.split(",");

        for (int i = 0; i < sec.length; i++) {
            String[] secd = sec[i].split("\\|");

            if (sec[i].trim().length() > 2) {

                String s0 = secd[0];
                String s1 = secd[1];
                String s2 = secd[2];
                String s3 = secd[3];

                listDescItems.add(s1);
            }

        }

        this.setListAdapter(new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, listDescItems));