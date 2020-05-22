int index = 0;
        for (int result : resultID) {
            //result is the single ID of an answer
            answerButtons.add(index,reserveButtons.get(result));
            index ++;
        }
        populateListView();