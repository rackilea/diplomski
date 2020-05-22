public class DetailKPIModel {
            private String kolom1, kolom2, kolom3, kolom4, kolom5, kolom6, kolom7, kolom8;

            public String getKolom1() {
                return kolom1;
            }

            public int getCount(String value){
                int count =0;
                if(value.equalsIgnoreCase(kolom1.substring(kolom1.length()-1))){
                    count++;
                }
                .
                .
                .

                if(value.equalsIgnoreCase(kolom8.substring(kolom8.length()-1))){
                    count++;
                }
return count;
            }
        }