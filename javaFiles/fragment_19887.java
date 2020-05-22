for(int i=0;i<arr.size();i++){
            //get the whole json array element
            JsonElement arrayElement = arr.get(i);
            //...
            //get question object
            JsonObject list = obj.get("question").getAsJsonObject();
            //cast to IQuestion using the Question class Gson deserializer
            IQuestion q = new Gson().fromJson(list, Question.class);
            //And, add using built in method
            this.test.setQuestion(q);