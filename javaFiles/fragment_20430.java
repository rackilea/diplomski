Uri myUri = Uri.parse(dir + "/" + theNamesOfFiles[position]);
            try {
                mp.stop();
                mp.reset();
                mp.setDataSource(MainActivity.this, myUri);
                mp.prepareAsync();
            } catch (Exception ex) {
                ex.printStackTrace();
            }