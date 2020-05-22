//load model
String rootPath="/some/where/"; 
Classifier cls = (Classifier) weka.core.SerializationHelper.read(rootPath+"tree.model");

//predict instance class values
Instances originalTrain= //load or create Instances to predict

//which instance to predict class value
int s1=0;  

//perform your prediction
double value=cls.classifyInstance(originalTrain.instance(s1));

//get the name of the class value
String prediction=originalTrain.classAttribute().value((int)value); 

System.out.println("The predicted value of instance "+
                    Integer.toString(s1)+
                    ": "+prediction);