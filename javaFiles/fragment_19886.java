for(int i=0;i<arr.size();i++){
            System.out.println("--------------------------------------Question"+i+"--------------------------------------------");
            JsonElement arrayElement = arr.get(i);
            JsonObject obj = arrayElement.getAsJsonObject();
            //add obj via variable assignment
            this.test.Add(obj);
            //or, add obj via set method
            this.test.setQuestion(i, obj); //or whatever parameters are needed :)