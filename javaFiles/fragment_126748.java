import java.io.*;
public class SerializeSVMModel {

    public static void main(String [] args) {

    // Set up your SVM model
    svm_model model = svm_train(...);
    // ...

    try {

        FileOutputStream fileOutputStream = new FileOutputStream("c:/svm/serialized_svm_model.ser");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream );

        // Writes the object
        objectOutputStream .writeObject(model );

    } catch(IOException e) {
        e.printStackTrace();
    } finally {
        if (objectOutputStream != null) {
            objectOutputStream.close();
        }
    }

}