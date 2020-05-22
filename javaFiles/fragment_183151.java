String[] techList = tag.getTechList();

        tagInfo.append("\nTech List\n");
        tagInfo.append("length = " + techList.length + "\n");
        for (int i = 0; i < techList.length; i++) {
            tagInfo.append(techList[i] + "\n ");
        }