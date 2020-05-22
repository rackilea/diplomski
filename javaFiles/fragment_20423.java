String question="what is this?";

        question= question.replace(' ', '+');


        try {
            Runtime.getRuntime().exec(new String[]{"cmd", "/c","start chrome https://www.google.com/search?q="+question});
        } catch (Exception e) {

        }