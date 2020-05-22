for(int i=0;i<arr.size();i++){
            //get the whole json array element
            JsonElement arrayElement = arr.get(i);
            //...
            //get question object
            JsonObject list = obj.get("question").getAsJsonObject();
            //cast question to correct interface based on question type
            if (type=="Multiple Choice") {
               IQuestionMultipleChoice questionMP = (IQuestionMultipleChoice) new Question(<params>);
               this.test.setQuestion(questionMP);
            } else if(type=="Yes/No") {
               //...