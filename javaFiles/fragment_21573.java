getAkun.getAkunUserKategori("jan","pemasukan", new Akun_Get.dataCallBack() {
        @Override
        public void getData(List<tblAkunDatabase> value) {
            result = value;

            if(result.size() > 0)
            {

                dat = new String[result.size()];
                for(int i = 0;i< result.size();i++)
                {
                    dat[i] = String.valueOf(result.get(i).getKdAkun());
                    ArrayAdapter<String> adapter = new ArrayAdapter<String>(Input_Jurnal.this, android.R.layout.simple_dropdown_item_1line, dat);
                    spin.setAdapter(adapter);

                }



            }
            else
            {
                dat = new String[1];
                dat[0] = "Empty";

                ArrayAdapter<String> adapter = new ArrayAdapter<String>(Input_Jurnal.this, android.R.layout.simple_list_item_single_choice, dat);
                spin.setAdapter(adapter);
            }
        }

    });