for(int i=0; i<arrayMethod.length; i++) {
            int[] arrayNested = arrayMethod[i];
            for(int j=0; j< arrayNested.length; j++) {
                g2.drawString(Integer.toString(arrayMethod[i][j]),(i +10) ,(j+10));
            }
        }