if (sb.length() > 4000) {
            Log.v("length", "sb.length = " + sb.length());
            int chunkCount = sb.length() / 4000;     // integer division
            for (int i = 0; i <= chunkCount; i++) {
                int max = 4000 * (i + 1);
                if (max >= sb.length()) {
                    Log.v("1st", "chunk " + i + " of " + chunkCount + ":" + sb.substring(4000 * i));
                } else {
                    Log.v("2nd", "chunk " + i + " of " + chunkCount + ":" + sb.substring(4000 * i, max));
                }
            }
        }