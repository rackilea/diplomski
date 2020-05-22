public static class TagEntry implements Comparable<TagEntry> {
        private int profileTag;
        private int dataOffset;
        private int dataLength;
        private byte[] data;

        public TagEntry(int profileTag, int dataOffset, int dataLength, byte[] data) {
            this.profileTag  = profileTag;
            this.dataOffset = dataOffset;
            this.dataLength = dataLength;
            this.data = data;
        }

        @Override
        public int compareTo(TagEntry o) {
            return (int)((this.profileTag&0xffffffffL) - (o.profileTag&0x0ffffffffL));
        }

        public int getProfileTag() {
            return profileTag;
        }

        public int getDataOffset() {
            return dataOffset;
        }

        public int getDataLength() {
            return dataLength;
        }

        public byte[] getData() {
            return data;
        }       
    }