public void Parser(){

        class TopGoalScores {
            String Emotion;
            int Color;
            String EmotionId;
            String IsHappyEmotion;

        }

        TopGoalScores topGoalScores=new TopGoalScores();

         try {
            SoapParser.parseBusinessObject(response.getProperty(0).toString(), topGoalScores);

         } catch (NumberFormatException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
         } catch (IllegalArgumentException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
         } catch (IllegalAccessException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
         } catch (InstantiationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
         }


    }