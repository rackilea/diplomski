new AsyncTask<Void, Void, Void>() {

            @Override
            protected Void doInBackground(Void... voids) {
                bd = helper.getWritableDatabase();
                File directorio = getExternalStoragePublicDirectory(DIRECTORY_DOWNLOADS);
                File file = new File(directorio, "art01.txt");
                try {
                    BufferedReader br = new BufferedReader(new FileReader(file));
                    String line;
                    String[] parts;
                    String sql = "delete from Articulos";
                    bd.execSQL(sql);

                    bd.beginTransaction();

                    while ((line = br.readLine()) != null) {
                        if (line.length() != 328) {
                            parts = line.split("\\#+");
                            Articulo arti = new Articulo(Integer.parseInt(parts[0]), parts[1], quitarEspaciosInt(parts[2]), quitarEspaciosInt(parts[3])
                                    , convertirDecimal(parts[4]), quitarEspaciosInt(parts[5]), quitarEspaciosInt(parts[6]), quitarEspaciosFloat(parts[7]), quitarEspaciosInt(parts[8]));
                            helper.addArticulo(arti);
                        }
                    }

                    br.close();
                    bd.setTransactionSuccessful();
                } catch (IOException e) {
//                    System.out.println(e.toString());
                } catch (Exception e) {

                } finally {
                    bd.endTransaction();
                    bd.close();
                }
                return null;
            }
        };