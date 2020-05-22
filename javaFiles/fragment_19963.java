mHolder = holder;
        try {
            Log.i("SurfaceHolder", "setting preview");
            camera.setPreviewDisplay(mHolder);  
        } catch (IOException e){
            e.printStackTrace();
        }