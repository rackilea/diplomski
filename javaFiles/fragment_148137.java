public class Test
    {

        private void replaceIndividuals(int individualsTurnover) {
            //individualTurnover = number of individuals I need to re-generate
           while(individualsTurnover > 1)
           {
               individualsTurnover = individualsTurnover - replaceIndividuals();
               //I am deducting this count because those many individuals are already created
           }
           //This is the only possible count > 0
           if(individualsTurnover == 1)
           {
               mutate();
           }
        }
        /**
         * 
         * @return No of individulas created
         */
        private int  replaceIndividuals() {
            int random = generator.nextInt(10);

            if (random < 1) {
                // generates one individual via mutation
                mutate();
                retrun 1;
            }
            else if (random < 2) {
                // generates one individual randomly
                createRandomIndividual();
                return 1;
            }
            else  {
                //generates two individuals by crossing-over individuals from a pool of parents
                crossover();

                return 2;
            }
        }
    }