ProgressHttpEntityWrapper.ProgressCallback progressCallback = new ProgressHttpEntityWrapper.ProgressCallback() {

        @Override
        public void progress(float progress) {
            //Use the progress
        }

    }

httpPost.setEntity(new ProgressHttpEntityWrapper(entityBuilder.build(), progressCallback));