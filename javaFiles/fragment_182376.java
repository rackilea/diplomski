checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
            if (b) {
                for (final File fileEntry : folder.listFiles())  {
                    if (fileEntry.exists()) {
                        if (fileEntry.delete())
                            System.out.println("Image deleted");
                        else
                            System.out.println(fileEntry + " not able to delete");
                    }
                }
            } else
                System.out.println("Don't delete images");
        }
    });