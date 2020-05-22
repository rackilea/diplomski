package Discord.message;

import de.btobastian.javacord.DiscordAPI;
import de.btobastian.javacord.entities.message.Message;
import me.NicksWorld.obj.DataCollection;
import me.NicksWorld.obj.IntegerRow;

public class Network {
    //Initialize collection of training data

    public  DataCollection TrainingData = new DataCollection();

    //End initialize collection of training data


    //Initialize result variable

    public Double datasetResult = 0.0;

    //End initialize result variable


    //Initialize fails variable

    public Integer fails = 0;

    //End initialize fails variable


    //Initialize done learning boolean

    public boolean doneLearning = false;

    //End initialize done learning boolean


    //Initialize weights

    //Initialize column 1's weight
    public double ColumnWeight1 = Math.round(Math.random());
    //Initialize column 2's weight
    public double ColumnWeight2 = Math.round(Math.random());
    //Initialize column 3's weight
    public double ColumnWeight3 = Math.round(Math.random());
    //Initialize column 4's weight
    public double ColumnWeight4 = Math.round(Math.random());

    //End initialize weights


    //Function to check weights against all datasets

    public boolean checkWeights() {
        for(Integer indexOfTrainingData=1;indexOfTrainingData<=TrainingData.get("int").size();indexOfTrainingData++) {

            //Reset variables for data

            datasetResult = 0.0;
            IntegerRow rowVar = (IntegerRow) TrainingData.get("int").get(indexOfTrainingData - 1);

            //End reseting of variables


            //loop through the row

            for(Integer indexOfRow=1;indexOfRow<=4;indexOfRow++) {
                //Determine which weight to use per value
                if(indexOfRow==1) {
                    datasetResult += ColumnWeight1*rowVar.get().get(0);
                }else if(indexOfRow==2) {
                    datasetResult += ColumnWeight2*rowVar.get().get(1);
                }else if(indexOfRow==3) {
                    datasetResult += ColumnWeight3*rowVar.get().get(2);
                }else if(indexOfRow==4) {
                    datasetResult += ColumnWeight4*rowVar.get().get(3);
                }
            }
            if(datasetResult==rowVar.get().get(4).intValue()) {

            }else {
                return false;
            }
        }
        return true;
    }


    //Function to learn

    public Boolean learn(IntegerRow ToLearn, Message message) {
        if(ToLearn.get().size()!=5) {
            return false;
        }

        //Add to training data list

        TrainingData.add(ToLearn);


        //loop through the training data
        for(Integer indexOfTrainingData=1;indexOfTrainingData<=TrainingData.get("int").size();indexOfTrainingData++) {
            //Reset variables for data

            datasetResult = 0.0;
            IntegerRow rowVar = (IntegerRow) TrainingData.get("int").get(indexOfTrainingData - 1);
            doneLearning = false;
            //End reseting of variables

            //determine when the for loop is complete

            while(doneLearning != true) {
                //loop through the row
                datasetResult = 0.0;
                for(Integer indexOfRow=1;indexOfRow<=4;indexOfRow++) {
                    //Determine which weight to use per value
                    if(indexOfRow==1) {
                        datasetResult += ColumnWeight1*rowVar.get().get(0);
                    }else if(indexOfRow==2) {
                        datasetResult += ColumnWeight2*rowVar.get().get(1);
                    }else if(indexOfRow==3) {
                        datasetResult += ColumnWeight3*rowVar.get().get(2);
                    }else if(indexOfRow==4) {
                        datasetResult += ColumnWeight4*rowVar.get().get(3);
                    }
                }
                if(datasetResult==rowVar.get().get(4).intValue()) {
                    //check if successful with other datasets
                    Boolean test = checkWeights();
                    if(test==true) {
                        return true;
                    }
                }else {
                    fails++;
                    if(fails>1000) {
                        TrainingData = new DataCollection(); return false;
                    }

                    if(fails == 50|fails == 100|fails == 150|fails == 200|fails == 250) message.reply("Working...");
                    //Re-randomize weights
                    ColumnWeight1 = Math.round(Math.random());
                    ColumnWeight2 = Math.round(Math.random());
                    ColumnWeight3 = Math.round(Math.random());
                    ColumnWeight4 = Math.round(Math.random());
                }
            }
            TrainingData = new DataCollection();
            return false;
        }
        TrainingData = new DataCollection();
        return false;
    }
    //
    public Double findResult = 0.0;
    public Double find(IntegerRow in) {
        findResult = 0.0;

        for(Integer indexOfRow=1;indexOfRow<=4;indexOfRow++) {
            //Determine which weight to use per value
            if(indexOfRow==1) {
                findResult += ColumnWeight1*in.get().get(0);
            }else if(indexOfRow==2) {
                findResult += ColumnWeight2*in.get().get(1);
            }else if(indexOfRow==3) {
                findResult += ColumnWeight3*in.get().get(2);
            }else if(indexOfRow==4) {
                findResult += ColumnWeight4*in.get().get(3);
            }
        }
        return findResult;
    }
}