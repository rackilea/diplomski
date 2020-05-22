public class FileOrder implements Comparable<FileOrder> {
        private String fileName;
        private Long updationTIme = 0l;

        @Override
        public String toString() {
            return "FileOrder [fileName=" + fileName + ", updationTIme=" + updationTIme + "]";
        }

        public FileOrder(String fileName, Long updationDate) {
            super();
            this.fileName = fileName;
            this.updationTIme = updationDate;
        }

        public String getFileName() {
            return fileName;
        }

        public void setFileName(String fileName) {
            this.fileName = fileName;
        }

        public Long getUpdationDate() {
            return updationTIme;
        }

        public void setUpdationDate(Long updationDate) {
            this.updationTIme = updationDate;
        }

        @Override
        public int compareTo(FileOrder o) {
            return o.getUpdationDate().compareTo(this.getUpdationDate());
        }

    }