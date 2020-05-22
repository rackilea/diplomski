StringBuilder tagInfo = new StringBuilder();

        byte[] tagId = tag.getId();

        for (byte aTagId : tagId) {
            tagInfo.append(Integer.toHexString(aTagId & 0xFF)).append(" ");
        }
        tagInfo.append("\n");