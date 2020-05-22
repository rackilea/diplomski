public static String[][] getList(){
            Categoria[] values = Categoria.values();

            String[][] result = new String[values.length][2]; 

            for (int i = 0; i < values.length; ++i) {
                String[] pair = {values[i].name(), values[i].toString()};
                result[i] = pair;
            }

            return result;
        }