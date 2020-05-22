class FilePathDTO {
        private final String filepath;
        private final Mat mat;
        private final Mat grey = new Mat();
        private final boolean isNotLastFilepath;

        public FilePathDTO(String filepath, Mat mat, boolean isLast) {
            this.filepath = filepath;
            this.mat = mat;
            this.isNotLastFilepath = isLast;
        }

        public String getFilepath() {
            return filepath;
        }

        public Mat getMat() {
            return mat;
        }

        public Mat getGrey() {
            return grey;
        }

        public boolean isNotLastFilepath() {
            return isNotLastFilepath;
        }
    }