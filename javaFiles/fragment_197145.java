private ArrayList<byte[]> queue = new ArrayList<byte[]>(3);
    private Camera.PreviewCallback mPreviewCallback = new Camera.PreviewCallback() {

        @Override
        public void onPreviewFrame(byte[] data, Camera camera) {        
            // TODO Auto-generated method stub

            if (queue.size() == 3) {
                queue.remove(0);
            }
            queue.add(data);
        }

    };