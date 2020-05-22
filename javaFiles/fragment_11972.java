Gson gson = new Gson();
        Parent[] parentObjArray = gson.fromJson(br, Parent[].class);

        Parent file2 = parentObjArray[3];
        parentObjArray[1].setChildren(new Parent[] { file2 });

        Parent folder2 = parentObjArray[1];
        Parent file1 = parentObjArray[2];
        parentObjArray[0].setChildren(new Parent[] { file1, folder2 });

        parentObjArray = new Parent[]{parentObjArray[0]};
        System.out.println(gson.toJson(parentObjArray));