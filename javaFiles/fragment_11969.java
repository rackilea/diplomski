BufferedReader br = new BufferedReader(new FileReader("array.json")); //File containing your initial json

Gson gson = new Gson();
Parent[] parentObjArray = gson.fromJson(br, Parent[].class);

Parent folder2 = parentObjArray[1];
parentObjArray[0].setChildren(new Parent[] { folder2 });

System.out.println(gson.toJson(parentObjArray));