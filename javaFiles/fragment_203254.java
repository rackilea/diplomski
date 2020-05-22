private void fillQuery() {

        fileListPart = new ArrayList<>();
        MultipartBody.Part filePart = null;
        if (mainFile != null) {
            if (mainFile.getName().endsWith(".pdf")) {
                filePart = MultipartBody.Part.createFormData("filename", mainFile.getName(), RequestBody.create(MediaType.parse("application/pdf"), mainFile));
            } else if (mainFile.getName().endsWith(".doc") || mainFile.getName().endsWith(".docx")) {
                filePart = MultipartBody.Part.createFormData("filename", mainFile.getName(), RequestBody.create(MediaType.parse("application/msword"), mainFile));
            }
            fileListPart.add(filePart);
        }

        requestBodyMap = new HashMap<>();
        RequestBody id = RequestBody.create(MediaType.parse("text/plain"), "id");
        RequestBody type = RequestBody.create(MediaType.parse("text/plain"), "type");
        RequestBody notes = RequestBody.create(MediaType.parse("text/plain"), "notes");

        requestBodyMap.put("id", id);
        requestBodyMap.put("type", type);
        requestBodyMap.put("notes", notes);

        for (int i = 0; i < dynamicCollectionWirhParameters.size(); i++) {
            String prefix = "list[";
            String checkIdParameter = "][id]";
            String checkIsCheckedParameter = "][is_checked]";
            String checkFileParameter = "][filename]";

            RequestBody checklist_id = RequestBody.create(MediaType.parse("text/plain"), "2");//id
            RequestBody is_checked = RequestBody.create(MediaType.parse("text/plain"), "1"); // server convert 1 and 0 to boolean value
            requestBodyMap.put(prefix + i + checkIdParameter, checklist_id);
            requestBodyMap.put(prefix + i + checkIsCheckedParameter, is_checked);

            if (dynamicCollectionFileCollection.get(i) != null) {
                File tempFile = dynamicCollectionFileCollection.get(i);
                filePart = null;
                if (tempFile.getName().endsWith(".pdf")) {
                    filePart = MultipartBody.Part.createFormData(prefix + i + checkFileParameter, dynamicCollectionFileCollection.get(i).getName(), RequestBody.create(MediaType.parse("application/pdf"), dynamicCollectionFileCollection.get(i)));
                } else if (dynamicCollectionFileCollection.get(i).getName().endsWith(".doc") || dynamicCollectionFileCollection.get(i).getName().endsWith(".docx")) {
                    filePart = MultipartBody.Part.createFormData(prefix + i + checkFileParameter, dynamicCollectionFileCollection.get(i).getName(), RequestBody.create(MediaType.parse("application/msword"), dynamicCollectionFileCollection.get(i)));
                }
                fileListPart.add(filePart);
            }
        }

    }