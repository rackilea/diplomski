while (reader.readPacket() == null) {
                if (!takeImage) {
                    reader.removeListener(this);
                    break;
                }
            }