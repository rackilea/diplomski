public static void loadData(){
        rdps= UserDao.getRs();
        data = new Vector<Vector<String>>();
        for (RS rdp:rdps){
            Vector<String> v = new Vector<String>();
            ...
            data.add(v);
        }

        tm = new DefaultTableModel(data,header){
            public boolean isCellEditable(int row, int column)
            {
                return false;
            }
        };

       jt.setModel(tm);  // <------------------- here

    }